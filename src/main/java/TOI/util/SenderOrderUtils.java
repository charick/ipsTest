package TOI.util;

import TOI.dao.DaoFactory;
import TOI.model.SenderOrder;
import TOI.model.User;
import com.taobao.api.domain.Trade;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Wk
 * Date: 13-8-5
 * Time: 下午12:02
 * To change this template use File | Settings | File Templates.
 */
public class SenderOrderUtils {
    public static SenderOrder generateSenderOrder(Trade trade){
        SenderOrder senderOrder = new SenderOrder();
        System.out.println(trade.getTid());
        senderOrder.setTid(trade.getTid().toString());
senderOrder.setPayTime(trade.getPayTime());
        senderOrder.setBuyerNIck(trade.getBuyerNick());
        senderOrder.setReceiverName(trade.getReceiverName());
        senderOrder.setRecerverState(trade.getReceiverState());
        senderOrder.setReceiverCity(trade.getReceiverCity());
        senderOrder.setReceiverAddress(trade.getReceiverAddress());
        senderOrder.setReceiverMobile(trade.getReceiverMobile());
        senderOrder.setReceiverPhone(trade.getReceiverPhone());
        senderOrder.setSellerFlag(trade.getSellerFlag().intValue());
        senderOrder.setSellerMemo(trade.getSellerMemo());
     return  senderOrder;

    }

    public static void main(String[] args){
        User user=new User("charick","61019205198567c9dc1e3f5a7d5714f4994fc58f1693cc542635718");
        TaobaoUtils2 taobaoUtils2=new TaobaoUtils2(user);
        List<Trade> tradeList= taobaoUtils2.tradeFilter("2013-07-30 00:00:00","2013-08-05 00:00:00");
        for(Trade trade:tradeList)
        {
            DaoFactory.getTraderDao().insert(SenderOrderUtils.generateSenderOrder(trade));

        }



    }
}
