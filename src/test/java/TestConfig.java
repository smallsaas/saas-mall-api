/**
 * @author hero
 * @date 11:26
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = AmApplication.class)*/
public class TestConfig {
    /*@Resource
    private ConfigMapper configMapper;

    @Resource
    private ConfigOverModelEndpoint configOverModelEndpoint;

    @Resource
    FrontProductCategoryService productCategoryService;*/

    /*@Test
    public void test(){
        Tip config = configOverModelEndpoint.getConfig(ConfigType.otherConfig.toString());
        System.out.println(JSON.toJSONString(config));
    }*/

    /*@Test
    public void test2(){
        String json = "{\"redirectUrl\":\"\",\"payOrderTimeout\":\"15\",\"autoSelectCoupon\":\"true\",\"sellerAutoSellership\":\"true\",\"logoUrl\":\"https://www.muaskin.com/images/avatar/72ef0f7992d3c41cf559eeed46d37f81.png\",\"orderCreatedEnable\":\"true\",\"latestReturnTime\":\"7\",\"infoUrl\":\"https://www.muaskin.com/wx/static/static/noTest.f3c8af24.png\",\"autoOffsell\":\"false\",\"promotedProductCarousel\":\"60\",\"autoValidationReceivingDeadline\":\"8\",\"flashFreight\":\"10\"}";
        Properties properties = JSONObject.parseObject(json, Properties.class);
        Tip config = configOverModelEndpoint.updateConfig(ConfigType.shopConfig.toString(),properties);
        System.out.println(JSON.toJSONString(config));
    }*/

    /*@Test
    public void test3(){
        String json = "{\"name\":\"111111\",\"isShowProducts\":1,\"wholesale\":1,\"visible\":1,\"sortOrder\":\"1\",\"description\":\"good\",\"productCategoryPropertyList\":[{\"displayName\":\"test1\",\"valueType\":\"STRING\",\"inputType\":\"INPUT_TEXT\",\"defaultValue\":\"good\",\"isRequired\":0,\"sortOrder\":\"1\"}]}";
        FrontProductCategoryModel productCategoryModel = JSONObject.parseObject(json, FrontProductCategoryModel.class);
        Integer affected = productCategoryService.createProductCategory(productCategoryModel);
        System.out.println(affected);
    }*/

    public static void main(String[] args) {
        String keyName = "latestReturnTime"; // "mall.invitationqr.redirectUrl"; // "mall.url.personal_center";
        int index = keyName.lastIndexOf(".");
        String keyNameSub = keyName.substring(index + 1);
        String[] keyNameSubStr = keyNameSub.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <keyNameSubStr.length ; i++) {
            if(i==0){
                sb.append(keyNameSubStr[0]);
            }else {
                String tempStr = keyNameSubStr[i];
                sb.append(tempStr.substring(0,1).toUpperCase()+tempStr.substring(1));
            }
        }
        System.out.println(sb.toString());
    }
}
