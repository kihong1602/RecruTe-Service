package com.hossi.recrute.common;

public class ViewResolver {
    private static String mainViewPath = "/WEB-INF/views/page.jsp";
    private static String errorViewPath = "/WEB-INF/views/error.jsp";
    public static String resolveMainViewPath(String viewName) {
        return "./pages/" + viewName + ".jsp";
    }
    public static String resolveErrorViewPath(String viewName) {return "./pages/error/" + viewName + ".jsp";}
    public static String getMainViewPath() {
        return mainViewPath;
    }
    public static String getErrorViewPath() {
        return errorViewPath;
    }
}

