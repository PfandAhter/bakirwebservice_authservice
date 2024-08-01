package com.bws.authservice.model.constants;

public class PropertyConstants {
    //MICROSERVICES PATHS

    //CONTROLLER PATHS
    public static final String REQUEST_SERVICE_AUTH_CONTROLLER = "${app.routesController.controllers.notSecure.authServiceController}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_LOGIN = "${app.routesController.requestMapping.notSecure.login.authUser}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_REGISTER = "${app.routesController.requestMapping.notSecure.login.registerUser}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_AUTH_SERVICE_CHANGE_PASSWORD = "${app.routesController.requestMapping.secure.login.passwordChange}";

    public static final String REQUEST_SECURE_REST_CONTROLLER_AUTH_SERVICE_LOGOUT = "${app.routesController.requestMapping.secure.login.logoutUser}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_REGISTER_AS_SELLER = "${app.routesController.requestMapping.notSecure.login.registerSeller}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_FORGET_PASSWORD = "${app.routesController.requestMapping.notSecure.password.passwordForget}";

    public static final String REQUEST_NOT_SECURE_REST_CONTROLLER_AUTH_SERVICE_CHANGE_PW_BY_CODE = "${app.routesController.requestMapping.notSecure.password.passwordChangeWithCode}";

}

