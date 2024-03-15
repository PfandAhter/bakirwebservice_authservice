package com.bws.authservice.model.constants;

public class PropertyConstants {
    //MICROSERVICES PATHS
    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_USER_SERVICE_USER_REGISTER = "${app.routesMicroservices.userService.registerUser}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_TOKEN_GENERATE = "${app.routesMicroservices.tokenService.generateToken}";

    //CONTROLLER PATHS
    public static final String REQUEST_NOTLOCKED_AUTHSERVICE = "${app.routesController.requestmapping.unlocked.authServiceController}";

    public static final String REQUEST_NOTLOCKED_AUTHUSER = "${app.routesController.notlocked.login.authUser}";

    public static final String REQUEST_NOTLOCKED_REGISTERUSER = "${app.routesController.notlocked.login.registerUser}";

}
