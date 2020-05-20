package com.honor.liuxinquan.day1108;

public class UtilPath {


    private static String windowsString = "Windows";

    /**

     * 获取到classes目录

     * @return path

     */

    public static String getClassPath(){

        String systemName = System.getProperty("os.name");



        //判断当前环境，如果是Windows 要截取路径的第一个 '/'

        if(!StringUtils.isNull(systemName) && systemName.indexOf(windowsString) !=-1){

            return UtilPath.class.getResource("/").getFile().toString().substring(1);

        }else{

            return UtilPath.class.getResource("/").getFile().toString();

        }

    }

    /**

     * 获取当前对象的路径

     * @param object

     * @return path

     */

    public static String getObjectPath(Object object){

        return object.getClass().getResource(".").getFile().toString();

    }

    /**

     * 获取到项目的路径

     * @return path

     */

    public static String getProjectPath(){

        return System.getProperty("user.dir");

    }

    /**

     * 获取 root目录

     * @return path

     */

    public static String getRootPath(){

        return getWebInf().replace("WEB-INF/", "");

    }

    /**

     * 获取输出HTML目录

     * @return

     */

    public static String getHTMLPath(){

        return getFreePath() + "html/html/";

    }

    /**

     * 获取输出FTL目录

     * @return

     */

    public static String getFTLPath(){

        return getFreePath() + "html/ftl/";

    }

    /**

     * 获取 web-inf目录

     * @return path

     */

    public static String getWebInf(){

        return getClassPath().replace("classes/", "");

    }

    /**

     * 获取模版文件夹路径

     * @return path

     */

    public static String getFreePath(){

        return getWebInf() + "ftl/";

    }

    /**

     * 文本换行，因为Linux  和 Windows 的换行符不一样

     * @return

     */

    public static String nextLine(){

        String nextLine = System.getProperty("line.separator");

        return nextLine;

    }

    /**

     * 获取images 路径

     * @return

     */

    public static String getImages(){

        return getRootPath() + "image/" ;

    }

    /**

     * 获取sitemap 路径

     * @return

     */

    public static String getSiteMapPath(){

        return getRootPath() + "txt/sitemap" ;

    }

    /**

     * 获取Txt 路径

     * @return

     */

    public static String getTxt(){

        return getRootPath() + "txt" ;

    }



}