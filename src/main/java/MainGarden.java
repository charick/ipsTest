import TOI.model.Product;
import TOI.util.ProductUtils;
import TOI.util.TaobaoUtils;

/**
 * Created with IntelliJ IDEA.
 * User: W.k
 * Date: 13-5-4
 * Time: 下午8:09
 * To change this template use File | Settings | File Templates.
 */
public class MainGarden {
    public static void main(String[] args) {
        TaobaoUtils tbUtil=TaobaoUtils.getInstance("6100a12fe2d4af999906188f11670ced65cf168ff8d1a0142635718") ;
////////////////////////更新product表内全部产品/////////////////////////
//        List<String> pids = ProductUtils.setProductListFromSQL();
//        for (String pid:pids){
//        Product p = ProductUtils.grabProductFromIKEA(pid);
//        ProductUtils.addToSQL(p,1);  }
 ////////////////////////更新item表内全部产品库存/////////////////////////
//        List<String> pids = ItemUtils.setItemListFromSQL();
//        for (String pid:pids){
//            IkeaStockUtil.StockInfo2SQL(pid);}
////////////////////////更新product表内一个产品/////////////////////////
        Product p = ProductUtils.grabProductFromIKEA("10265127");
        ProductUtils.addToSQL(p, 1);
//////////////////////从SQL获取一个产品/////////////////////////
//         Product p = ProductUtils.setFromSQL("S69932184");
////////////////////////上传至淘宝/////////////////////////
        tbUtil .addTaobaoItem(p);
        tbUtil.uploadExtraPic(p);
///////////////////////////////////////////////////////////////
//       TaobaoUtils.saveTBcategory2File();
//        TaobaoUtils.getPicCategory("宝贝图片");
////////////////////////删除未引用图片/////////////////////////
//        for(int i=0;i<20;i++)
//        TaobaoUtils.deleteUnusePics();
//////////////////////更新线上宝贝/////////////////////////
//        TaobaoUtils.updateOnlineItem(p);
//////////////////////全部更新线上////////////////////////
//        List<String> pids = ProductUtils.setProductListFromSQL();
//        for (String pid:pids){
//            Product p = ProductUtils.setFromSQL(pid);
//            TaobaoUtils.updateOnlineItem(p);
//        }
////////////////////////获取线上宝贝/////////////////////////
//        TaobaoUtils.getOnlineProducts();

////////////////////////更新SQL内虚重/////////////////////////
//        List<String> pids = ProductUtils.setProductListFromSQL();
//        for (String pid:pids){
//        Product p = ProductUtils.setFromSQL(pid);
//         p.setVirtualWeight2();
//            ProductUtils.addToSQL(p,0);
//           }
    }
}
