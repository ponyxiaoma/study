package com.mjq.mybatis.util;

/**
 * Created by majingqiang on 2018/10/31.
 */
public class MybatisGenerator {
//
//    /**
//     * <p>
//     * 读取控制台内容
//     * </p>
//     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotEmpty(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://192.168.3.12:3306/pmsddl?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true");
//        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
//        mpg.setDataSource(dsc);
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
////        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
////            @Override
////            public String outputFile(TableInfo tableInfo) {
////                // 自定义输入文件名称
////                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
////                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
////            }
////        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/main/src/main/java");
//        //设置类作者
//        gc.setAuthor("majingqiang");
//        gc.setOpen(false);
//        gc.setDateType(DateType.ONLY_DATE);
//        gc.setEntityName("%sEntity");
//        gc.setMapperName("%sDAO");
//        mpg.setGlobalConfig(gc);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setEntityLombokModel(true);
//        //表名
//        String[] s = {"t_merchant_pay"};
//        strategy.setInclude(s);
//        //去除数据库表前缀
//        strategy.setTablePrefix("t_");
//        //排除生成非主键字段
//        HashSet<String> set = new HashSet<>();
//        set.add("id");
//        set.add("gmt_create");
//        set.add("gmt_modified");
//        strategy.setExcludeField(set);
//        mpg.setStrategy(strategy);
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.mjq.pms");
//        mpg.setPackageInfo(pc);
//        mpg.setTemplateEngine(new VelocityTemplateEngine());
//        mpg.execute();
//    }
}
