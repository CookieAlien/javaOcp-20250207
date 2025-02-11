package util;

import java.util.regex.Pattern;

import model.ShopOrder;

public class Helper {
	 // 驗證帳號 (6~16位英文數字，首字不能為數字)
    public static boolean validateUsername(String username) {
        return Pattern.matches("^[A-Za-z][A-Za-z0-9]{5,15}$", username);
    }

    // 驗證密碼 (6~20位，須包含英文大小寫和數字)
    public static boolean validatePassword(String password) {
        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,20}$", password);
    }

    // 驗證姓名 (2~16位中英文字)
    public static boolean validateName(String name) {
        return Pattern.matches("^[\u4e00-\u9fa5A-Za-z]{2,16}$", name);
    }

    // 驗證電子郵件 (須為電郵格式)
    public static boolean validateEmail(String email) {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", email);
    }

    // 驗證手機號碼 (09開頭的10位數字)
    public static boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.matches("^09\\d{8}$", phoneNumber);
    }
    
    public static String getShoppingInfo(String name, ShopOrder order) {
    	StringBuilder s = new StringBuilder();
    	s.append("客戶").append(name).append("您好").append("\n");
    	s.append("以下為您的訂單\n");
    	if (order.getPs5pro()>0) {
			s.append("PS5 PRO: ").append(String.format("%5s", order.getPs5pro())).append("台\n");
		}
    	if (order.getPs5slim()>0) {
			s.append("PS5 Slim: ").append(String.format("%5s", order.getPs5slim())).append("台\n");
		}
    	if (order.getNswitch()>0) {
			s.append("Nintendo Switch: ").append(String.format("%5s", order.getNswitch())).append("台\n");
		}
    	if (order.getSteamdeck()>0) {
			s.append("Steam Deck: ").append(String.format("%5s", order.getPs5pro())).append("台\n");
		}
    	if (order.getXboxcontroller()>0) {
			s.append("XBOX無線手把: ").append(String.format("%5s", order.getPs5pro())).append("支\n");
		}
    	s.append("=======================\n")
    	.append("小計:").append(String.format("%8s", order.getSum())).append("元\n");
    	return s.toString();
    }
    
    public static String cashPaymentInfo(String name, ShopOrder order, int cash) {
		StringBuilder s = new StringBuilder();
		s.append(getShoppingInfo(name, order));
		int change = cash - order.getSum();
		if (change < 0) {
			s.append("付款金額不足!");
		}else {
			s.append("付款金額:").append(cash);
			if (change == 0) {
				s.append("\n無須找零!");
			} else {
				s.append("  找零:").append(change).append("\n");
				int[] coins = new int[] {1000,500,100,50,10,5,1};
				for (int coin : coins) {
					if (change >= coin) {
						int amount = change / coin;
						s.append(coin).append("元: ").append(amount).append(coin >= 100 ? "張" : "枚").append("\n");
						change %= coin;
					}
				}
			}
		}
    	
    	return s.toString();
	}
    
}
