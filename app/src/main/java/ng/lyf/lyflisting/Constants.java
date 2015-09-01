package ng.lyf.lyflisting;

public class Constants {

    public static boolean       TESTING = false;
    public static boolean       DEBUG = false;

    // other payment options strings
    public static final String  CARD_PAYMENT_STRING = "Card Payment";
    public static final String  GT_PAYMENT_STRING = "GTPay";

    // market URL
    public static final String  MARKET_URL = "market://details?id=com.dealdey";

    // URLs
    public static final String  ABSOLUTE_BASE_URL_STAGING = "http://api-staging.dealdey.com";
    public static final String  ABSOLUTE_BASE_URL_PRODUCTION = "http://api.dealdey.com";
    public static final String  ABSOLUTE_BASE_URL = DEBUG ? ABSOLUTE_BASE_URL_STAGING : ABSOLUTE_BASE_URL_PRODUCTION;

    public static final String  WEB_PAY_ABSOLUTE_BASE_URL_STAGING = "http://api-staging.dealdey.com";
    public static final String  WEB_PAY_ABSOLUTE_BASE_URL_PRODUCTION = "http://www.dealdey.com";
    public static final String  WEB_PAY_ABSOLUTE_BASE_URL = DEBUG ? WEB_PAY_ABSOLUTE_BASE_URL_STAGING : WEB_PAY_ABSOLUTE_BASE_URL_PRODUCTION;

    public static final String  ABSOLUTE_BASE_SHARE_URL_STAGING = "http://api-staging.dealdey.com";
    public static final String  ABSOLUTE_BASE_SHARE_URL_PRODUCTION = "http://www.dealdey.com";
    public static final String  BASE_SHARE_URL = DEBUG ? ABSOLUTE_BASE_SHARE_URL_STAGING : ABSOLUTE_BASE_SHARE_URL_PRODUCTION;

    public static final String  BASE_URL_STAGING = ABSOLUTE_BASE_URL_STAGING + "/api/v1";
    public static final String  BASE_URL_PRODUCTION = ABSOLUTE_BASE_URL_PRODUCTION + "/api/v1";
    public static final String  BASE_URL = DEBUG ? BASE_URL_STAGING : BASE_URL_PRODUCTION;
    public static final String  DOMAIN = "dealdey.com";

    // SECURE URLs
    public static final String  SECURE_ABSOLUTE_BASE_URL_STAGING = "https://api-staging.dealdey.com";
    public static final String  SECURE_ABSOLUTE_BASE_URL_PRODUCTION = "https://api.dealdey.com";
    public static final String  SECURE_ABSOLUTE_BASE_URL = DEBUG ? SECURE_ABSOLUTE_BASE_URL_STAGING : SECURE_ABSOLUTE_BASE_URL_PRODUCTION;

    public static final String  SECURE_WEB_PAY_ABSOLUTE_BASE_URL_STAGING = "https://api-staging.dealdey.com";
    public static final String  SECURE_WEB_PAY_ABSOLUTE_BASE_URL_PRODUCTION = "https://www.dealdey.com";
    public static final String  SECURE_WEB_PAY_ABSOLUTE_BASE_URL = DEBUG ? SECURE_WEB_PAY_ABSOLUTE_BASE_URL_STAGING : SECURE_WEB_PAY_ABSOLUTE_BASE_URL_PRODUCTION;

    public static final String  SECURE_BASE_URL_STAGING = SECURE_ABSOLUTE_BASE_URL_STAGING + "/api/v1";
    public static final String  SECURE_BASE_URL_PRODUCTION = SECURE_ABSOLUTE_BASE_URL_PRODUCTION + "/api/v1";
    public static final String  SECURE_BASE_URL = DEBUG ? SECURE_BASE_URL_STAGING : SECURE_BASE_URL_PRODUCTION;


    public static final String  URL_FOR_VERIFYING_SUCCESS_PAYMENT_STAGING = "api-staging.dealdey.com/orders/";
    public static final String  URL_FOR_VERIFYING_SUCCESS_PAYMENT_PRODUCTION = "dealdey.com/orders/";
    public static final String  URL_FOR_VERIFYING_SUCCESS_PAYMENT = DEBUG ? URL_FOR_VERIFYING_SUCCESS_PAYMENT_STAGING : URL_FOR_VERIFYING_SUCCESS_PAYMENT_PRODUCTION;

    public static final String  URL_FOR_TERMS_AND_CONDITION = WEB_PAY_ABSOLUTE_BASE_URL + "/terms?app=1";

    public static final String  URL_FOR_QUICKTELLER_WALLET_FUND = "https://www.quickteller.com/dealdey";

    // configuration URL
    public static final String  CONFIGURATION_URL = "/configurations";

    // get categories of selected state (http://api-staging.dealdey.com/api/v1/states/:state_id/categories)
    public static final String  STATE_URL = "/states/";
    public static final String  CATEGORIES_URL = "/categories";

    // deals related URLs
    public static final String  ALL_DEALS_URL = "/deals";
    public static final String  CATEGORY_DEALS_URL = "/categories/";
    public static final String  DEAL_DETAILS_URL = "/deals/";
    public static final String  DEAL_VARIANTS_URL = "/variants/";

    // store
    public static final String  STORE_URL = "/stores/";

    // search
    public static final String  SEARCH_URL = "/search";

    // sign in
    public static final String  SIGN_UP_URL = "/users";
    public static final String  SIGN_IN_URL = "/user/sign_in";
    public static final String  LOGOUT_URL = "/user/sign_out";
    // FB sign in / sign up
    public static final String  LOGIN_USING_FB_URL = "/fb_auth";
    // Forgot Password
    public static final String  FORGOT_PASSWORD_URL = "/user/forgot_password";
    // Change Password
    public static final String  CHANGE_PASSWORD_URL = "/user/reset_password";
    // Change Password in Overflow Menu
    public static final String  CHANGE_PASSWORD_OVERFLOW_URL = "/user/change_password";
    // enter / update mobile number
    public static final String  UPDATE_MOBILE_NUMBER_URL = "/user/update_mobile";
    // Send Mobile Verification code
    public static final String  SEND_MOBILE_VERIFICATION_URL = "/user/send_mobile_verification_code";
    // Mobile Verification
    public static final String  MOBILE_VERIFICATION_URL = "/user/mobile_number_verification";
    // wallet
    public static final String  WALLET_URL = "/user/wallet";
    // orders
    public static final String  ORDERS_URL = "/orders";
    // transactions
    public static final String  TRANSACTIONS_URL = "/transactions";
    // order details
    public static final String  ORDER_DETAILS_URL = "/orders/";
    // coupon detail
    public static final String  COUPON_DETAILS_URL = "/coupons/";
    //download PDF
    public static final String  DOWNLOAD_PDF = "/download.pdf";
    //subscribe for newsletter
    public static final String  EMAIL_SUBSCRIBE_URL = "/email_subscriptions/subscribe";
    // wallet
    public static final String  DEALDEY_VERIFY_VOUCHER_URL = "/voucher_codes/verify";
    public static final String  DEALDEY_REDEEM_VOUCHER_URL = "/voucher_codes/redeem";
    public static final String  SUREGIFTS_VERIFY_VOUCHER_URL = "/suregifts_transactions/verify";
    public static final String  SUREGIFTS_REDEEM_VOUCHER_URL = "/suregifts_transactions";


    // cart related URLs
    public static final String  CART_URL = "/carts";
    public static final String  CART_ITEMS_URL = "/cart_items/";
    public static final String  REMOVE_URL = "/remove";
    public static final String  CHANGE_QUANTITY_URL = "/change_quantity";
    public static final String  CHANGE_PICK_UP_LOCATION_URL = "/change_pickup_location";
    public static final String  APPLY_DISCOUNT_URL = "/apply_discount";
    public static final String  VALIDATE_CART = "/checkout";

    // shipping address related URLs
    public static final String  SHIPPING_ADDRESSES_URL = "/shipping_addresses";
    public static final String  LIST_ADDRESS_FOR_CART_URL = "/list_for_cart";
    public static final String  CREATE_ADDRESS_FOR_CART_URL = "/create_for_cart";
    public static final String  UPDATE_ADDRESS_FOR_CART_URL = "/update_for_cart";

    // Payment Methods
    public static final String  PAYMENT_METHODS_URL = "/payment_options";
    public static final String  PAY_USING_WALLET_URL = "/complete_by_wallet";
    public static final String  PAY_USING_OT_WALLET_URL = "/complete_by_ot_wallet";

    // login for payment
    public static final String  LOGIN_FOR_PAYMENT_URL = "/web_view/login";

    //GCM Device Registration
    public static final String  GCM_REGISTER_DEVICE_URL = "/gcm_devices";

    //Banner Images Request
    public static final String  BANNER_IMAGES_URL = "/banner_images";


    ////////////////////////////
    // Params
    ///////////////////////////
    public static final String  PARAM_ACCESS_KEY = "access_key";
    public static final String  PARAM_ACCESS_VALUE = DEBUG ? "android-testing" : "b4a4fc192e702815379158b5e391c544";

    public static final String  PARAM_AUTH_TOKEN_KEY = "auth_token";

    // params for wallet
    public static final String  PARAM_VOUCHER_CODE_KEY = "voucher_code";
    public static final String  PARAM_AMOUNT_KEY = "amount";
    public static final String  PARAM_SUREGIFTS_AMOUNT_KEY = "suregifts_transaction[amount]";
    public static final String  PARAM_SUREGIFTS_CODE_KEY = "suregifts_transaction[voucher_code]";

    // Params for configuration
    public static final String  PARAM_STATE_ID = "state_id";

    // Params for deals listing
    public static final String  PARAM_CURRENT_PAGE_NUMBER = "page";
    public static final String  PARAM_PAGE_SIZE = "per_page";

    // Params for search
    public static final String  PARAM_SEARCH = "search";
    public static final String  SEARCH_SIZE = "200";


    // Params for buying deals
    public static final String  PARAM_DEAL_ID = "deal_id";
    public static final String  PARAM_VARIANT_ID = "variant_id";
    public static final String  PARAM_DEAL_QUANTITY = "cart_item[quantity]";

    // Params for sign in
    public static final String  PARAM_EMAIL = "email";
    public static final String  PARAM_PASSWORD = "password";
    public static final String  PARAM_SOURCE_APP = "source_app";
    public static final String  PARAM_SOURCE_APP_VALUE = "android";

    // Params for facebook sign in
    public static final String  PARAM_FB_ID = "user[fb_id]";
    public static final String  PARAM_FB_EMAIL = "user[email]";
    public static final String  PARAM_FB_FIRST_NAME = "user[firstname]";
    public static final String  PARAM_FB_LAST_NAME = "user[lastname]";
    public static final String  PARAM_FB_ACCESS_TOKEN = "user[access_token]";

    // Params for sign up
    public static final String  PARAM_SIGN_UP_EMAIL = "user[email]";
    public static final String  PARAM_SIGN_UP_PASSWORD = "user[password]";
    public static final String  PARAM_SIGN_UP_FIRST_NAME = "user[firstname]";
    public static final String  PARAM_SIGN_UP_LAST_NAME = "user[lastname]";
    public static final String  PARAM_SIGN_UP_MOBILE = "user[mobile]";
    public static final String  PARAM_SIGN_UP_STATE_ID = "email_subscription_state_id";

    // Params for mobile verification
    public static final String  PARAM_MOBILE = "mobile";
    public static final String  PARAM_MOBILE_VERIFICATION_CODE = "mobile_verification_code";

    // Params for change password
    public static final String  PARAM_RESET_PASSWORD_TOKEN = "user[reset_password_token]";
    public static final String  PARAM_RESET_PASSWORD = "user[password]";
    public static final String  PARAM_RESET_CONFIRM_PASSWORD = "user[password_confirmation]";
    public static final String  PARAM_RESET_CURRENT_PASSWORD = "user[current_password]";

    // Params for cart
    public static final String  PARAM_QUANTITY = "quantity";
    public static final String  PARAM_PICK_UP_LOCATION_ID = "pickup_location_id";
    public static final String  PARAM_PROMOTION_CODE = "coupon_code";

    // Params for picking shipping address for cart
    public static final String  PARAM_SA_ID = "shipping_address_id";

    // Params for Creating shipping address
    public static final String  PARAM_SA_NAME = "shipping_address[name]";
    public static final String  PARAM_SA_ADDRESS_LINE = "shipping_address[address_line]";
    public static final String  PARAM_SA_LANDMARK = "shipping_address[landmark]";
    public static final String  PARAM_SA_STATE = "shipping_address[state]";
    public static final String  PARAM_SA_AREA = "shipping_address[area]";

    // Params for Payment (completing order)
    public static final String  PARAM_PAYMENT_MODE = "order[payment_mode]";
    public static final String  PARAM_VALUE_WALLET = "wallet";
    public static final String  PARAM_VALUE_CARD = "web_pay";
    public static final String  PARAM_VALUE_GTPAY = "gtpay";

    public static final String  PARAM_PARTIAL_WALLET_PAYMENT = "partial_wallet_payment";
    public static final String  PARAM_VALUE_TRUE = "1";
    public static final String  PARAM_VALUE_FALSE = "0";

    public static final String  PARAM_PAYMENT_TOKEN = "payment_token";

    //Params for banner images
    public static final String  PARAM_BANNER_IMAGE_TYPE = "type";

    // Params for subscribing email
    public static final String  PARAM_SUBSCRIBE_EMAIL = "email";

    // Params for registering device to GCM
    public static final String  PARAM_DEBUG = "debug";
    public static final String  PARAM_REGISTRATION_ID = "registration_id";
    public static final String  DEVICE_ID = "device_id";

    // Others
    public static final String  EMAIL_REGEX = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
    public static final String  MOBILE_REGEX = "^0(7|8|9)[0-9]{9}$";

    // GCM Push Notifications
    public static final String  SENDER_ID = "210062839037";

    // PDF Related constants
    public static final String  PDF_OPEN_INTENT = "com.adobe.reader";
    public static final String  FILE_NAME = "FILE_NAME";

    public static String        ABSOLUTE_BASE_SHARE_URL = "http://www.dealdey.com";
}