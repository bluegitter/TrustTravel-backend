package org.fisco.bcos.utils;

import com.alibaba.fastjson.JSONObject;
import org.fisco.bcos.model.CommonResult;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoderFactory;

import java.util.HashMap;

public class HelpUtils {
    public static String getResJson(String statusCode, boolean success, String dataName, Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status_code", statusCode);
        jsonObject.put("success", success);
        jsonObject.put(dataName, data);
        return jsonObject.toJSONString();
    }

    public static void addTxDetails(HashMap hashMap, CommonResult commonResult, TransactionReceipt receipt) {
        hashMap.put("txHash", receipt.getTransactionHash());
        commonResult.setData(hashMap);
    }

    public static TransactionDecoder getTxDecoder4Travel() {
        // TxDecodeSample合约ABI
        String abi = "[{\"constant\":true,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserMoney\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"username\",\"type\":\"string\"}],\"name\":\"GetUserAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"score\",\"type\":\"uint256\"}],\"name\":\"addCommentForHotel\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"address\"}],\"name\":\"userInfo\",\"outputs\":[{\"name\":\"userName\",\"type\":\"string\"},{\"name\":\"Owner_money\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"txHash\",\"type\":\"string\"}],\"name\":\"setUserSceneOrderTx\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserOrdersCount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"passwd\",\"type\":\"string\"}],\"name\":\"UserLogin\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"txHash\",\"type\":\"string\"}],\"name\":\"setUserSceneOrderCommentTx\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"txHash\",\"type\":\"string\"}],\"name\":\"setUserOrderCommentTx\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"txHash\",\"type\":\"string\"}],\"name\":\"setUserOrderTx\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserSceneCount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"passwd\",\"type\":\"string\"},{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"UserRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"score\",\"type\":\"uint256\"}],\"name\":\"addCommentForScene\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"_name\",\"type\":\"string\"}],\"name\":\"changeUserName\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getAccountType\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserSceneOrdersComment\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserOrdersComment\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserOrdersInfo\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"address\"}],\"name\":\"accountType\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserOtherScene\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserName\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"_detailaddr\",\"type\":\"string\"},{\"name\":\"_hotel\",\"type\":\"string\"},{\"name\":\"_roomType\",\"type\":\"string\"},{\"name\":\"_fromDate\",\"type\":\"string\"},{\"name\":\"_toDate\",\"type\":\"string\"},{\"name\":\"_OTA\",\"type\":\"string\"},{\"name\":\"_totalPrice\",\"type\":\"uint256\"},{\"name\":\"f2\",\"type\":\"uint256\"}],\"name\":\"initializeOrder\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"s1\",\"type\":\"string\"},{\"name\":\"s2\",\"type\":\"string\"}],\"name\":\"compareStringsbyBytes\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"pure\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_addr\",\"type\":\"address\"},{\"name\":\"_province\",\"type\":\"string\"},{\"name\":\"_city\",\"type\":\"string\"},{\"name\":\"s_name\",\"type\":\"string\"},{\"name\":\"s_price\",\"type\":\"uint256\"},{\"name\":\"_OTA\",\"type\":\"string\"},{\"name\":\"f1\",\"type\":\"uint256\"}],\"name\":\"bookOrder\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserOrdersRoom\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_idx\",\"type\":\"uint256\"},{\"name\":\"_addr\",\"type\":\"address\"}],\"name\":\"getUserSceneOrdersInfo\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"username\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"Users\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"_addr\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"_detailaddr\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"hotel\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"price\",\"type\":\"uint256\"}],\"name\":\"BookingHotel\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"_addr\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"s_name\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"price\",\"type\":\"uint256\"}],\"name\":\"BookingScene\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"_addr\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"_idx\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"content\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"score\",\"type\":\"uint256\"}],\"name\":\"CommentsInfo\",\"type\":\"event\"}]";
        String bin = "";
        TransactionDecoder txDecodeSampleDecoder = TransactionDecoderFactory.buildTransactionDecoder(abi, bin);
        return txDecodeSampleDecoder;
    }

}
