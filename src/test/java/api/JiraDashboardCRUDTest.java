package api;

import constants.CommonConsts;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.dashboardWithBuilder.Dashboard;
import pojo.dashboardWithBuilder.Gadget;
import pojo.dashboardWithBuilder.SharePermission;
import utils.*;

import java.util.ArrayList;
import java.util.List;

public class JiraDashboardCRUDTest {

    protected String dashBoardId;
    protected String gadgetId;

    @Test(priority=1)
    public void createDashboard() throws Exception {
        List<SharePermission> sharePermissionList = List.of(new SharePermission.Builder().withType(CommonConsts.TYPE).build());

        Dashboard dashboard = JiraPojoHelper.generateJsonForDashboardCreation(CommonConsts.DESCRIPTION,CommonConsts.NAME,sharePermissionList);

        Response res = Authorization.loginToJira()
                .header("Content-Type", ContentType.JSON)
                .body(dashboard)
                .when()
                .post(APIPathes.createDashboard)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
        dashBoardId = res.path("id");
        if(dashBoardId == null){
            throw new IllegalArgumentException("Dashboard with same name already exists.");
        }
            System.out.println("dashboard id = "+ dashBoardId);
            Assert.assertNotNull(res.path("id"));


    }

    @Test(priority=2)
    public void addGadgetToDashboard(){

        Gadget gadget = JiraPojoHelper.generateJsonForAddGadget(CommonConsts.COLOR, false,CommonConsts.MODULE_KEY,CommonConsts.TITLE
                ,CommonConsts.COLUMN,CommonConsts.ROW);

        Response res = Authorization.loginToJira()
                .header("Content-Type", ContentType.JSON)
                .pathParam("dashboardId", dashBoardId)
                .body(gadget)
                .post(APIPathes.gadget)
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response();
        gadgetId = res.jsonPath().get("id").toString();

    }

    @Test(priority=3)
    public void getJiraDashboard() {
        ResponseBody res = Authorization.loginToJira()
                .header("Content-Type",ContentType.JSON)
                .pathParam("id", dashBoardId)
                .get(APIPathes.dashboard)
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response().getBody();
        Assert.assertEquals(res.path("id"),dashBoardId);
        Assert.assertFalse(res.asPrettyString().isBlank());
    }

    @Test(priority=4)
    public void getJiraGadget() {
        ResponseBody res = Authorization.loginToJira()
                .header("Content-Type",ContentType.JSON)
                .pathParam("dashboardId", dashBoardId)
                .get(APIPathes.getGadget)
                .then()
                .statusCode(200).contentType(ContentType.JSON)
                .extract().response().getBody();
        Assert.assertTrue(res.path("gadgets.id").toString().contains(gadgetId));
        Assert.assertFalse(res.asPrettyString().isBlank());
    }

    @Test(priority=5)
    public void updateJiraGadget(){
        String newTitle = "My new gadget title";
        Gadget gadget = new Gadget.Builder().withColor(CommonConsts.COLOR).withPosition(CommonConsts.COLUMN,CommonConsts.ROW).withTitle(newTitle).build();
        Authorization.loginToJira()
                .header("Content-Type",ContentType.JSON)
                .pathParam("dashboardId", dashBoardId)
                .pathParam("gadgetId",gadgetId)
                .body(gadget)
                .put(APIPathes.updateGadget)
                .then()
                .statusCode(204).contentType(ContentType.JSON);
    }

    @Test(priority=6)
    public void updateJiraDashboard(){
        String newType = "group";
        String name = "test";
        String description = "test";
        List<SharePermission> sharePermissionList = List.of(new SharePermission.Builder().withType(newType).build());
        Dashboard dashboardUpdate = new Dashboard.Builder()
                .withEditPermissions(new ArrayList<>())
                .withName(name)
                .withDescription(description)
                .withSharePermissions(sharePermissionList)
                .build();
        Authorization.loginToJira()
                .header("Content-Type",ContentType.JSON)
                .pathParam("id", dashBoardId)
                .body(dashboardUpdate)
                .put(APIPathes.dashboard)
                .then()
                .statusCode(200).contentType(ContentType.JSON);
    }

    @Test(priority=7)
    public void deleteJiraGadget(){
        Authorization.loginToJira()
                .header("Content-Type",ContentType.JSON)
                .pathParam("dashboardId", dashBoardId)
                .pathParam("gadgetId",gadgetId)
                .delete(APIPathes.deleteGadget)
                .then()
                .statusCode(204).contentType(ContentType.JSON);
    }

    @Test(priority=8)
    public void deleteJiraDashboard(){
        Authorization.loginToJira()
                .header("Content-Type",ContentType.JSON)
                .pathParam("id", dashBoardId)
                .delete(APIPathes.dashboard)
                .then()
                .statusCode(204).contentType(ContentType.JSON);

    }
}
