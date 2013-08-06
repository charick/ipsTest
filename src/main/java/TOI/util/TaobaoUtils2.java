package TOI.util;

import TOI.Constant.Constant;
import TOI.model.User;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Trade;
import com.taobao.api.request.TradeFullinfoGetRequest;
import com.taobao.api.request.TradesSoldGetRequest;
import com.taobao.api.response.TradeFullinfoGetResponse;
import com.taobao.api.response.TradesSoldGetResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Wk
 * Date: 13-8-5
 * Time: 上午10:50
 * To change this template use File | Settings | File Templates.
 */
public class TaobaoUtils2 {
    public String sessionKey;
    public TaobaoUtils2(User user){
        sessionKey= user.getSessionKey();}
    public ArrayList<Trade> tradeFilter(String start, String end) {
        try {
            TaobaoClient client = new DefaultTaobaoClient(Constant.url, Constant.appkey, Constant.appSecret);
            TradesSoldGetRequest req = new TradesSoldGetRequest();
            req.setFields("tid,pay_time,buyer_nick,receiver_name, receiver_state, receiver_city, receiver_district, receiver_address, receiver_zip, receiver_phone,seller_flag");
            Date dateTime = SimpleDateFormat.getDateTimeInstance().parse(start);
            req.setStartCreated(dateTime);
            Date dateTime2 = SimpleDateFormat.getDateTimeInstance().parse(end);
            req.setEndCreated(dateTime2);
            req.setStatus("WAIT_SELLER_SEND_GOODS");
//            req.setBuyerNick("tb749866_2012");

            TradesSoldGetResponse response = client.execute(req,sessionKey);
            List<Trade> trades = response.getTrades();
            ArrayList<Trade> tradeList = new ArrayList<Trade>();

            for (Trade trade : trades) {
                if (trade.getSellerFlag() == 1) {
                    enhanceTrade(trade);
                    tradeList.add(trade);
                } else
                    System.out.println("刚刚掠过了一个订单:" + trade.getBuyerNick());


            }


            return tradeList;
        } catch (ApiException e1) {
            e1.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    private  void enhanceTrade(Trade trade) {
        try {
            TaobaoClient client=new DefaultTaobaoClient(Constant.url, Constant.appkey, Constant.appSecret);
            TradeFullinfoGetRequest req=new TradeFullinfoGetRequest();
            req.setFields("receiver_mobile,seller_memo");
            req.setTid(trade.getTid());
            TradeFullinfoGetResponse response = client.execute(req , sessionKey);
            trade.setReceiverMobile(response.getTrade().getReceiverMobile());
            trade.setSellerMemo(response.getTrade().getSellerMemo());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
