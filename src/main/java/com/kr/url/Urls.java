package com.kr.url;

public enum Urls {

	Google("https://media.licdn.com/dms/image/C4D0BAQHiNSL4Or29cg/company-logo_100_100/0/1519856215226?e=1691020800&v=beta&t=DZcChNb6goFHgiU4iCJnCXMGadF1CuH29Ey-RSluK2E"),
	Amazon("https://media.licdn.com/dms/image/C560BAQHTvZwCx4p2Qg/company-logo_100_100/0/1612205615891?e=1691020800&v=beta&t=vxJKGUxGpVJWcqgM58hMETLy48-3p4nEr6BOLKaW5TY"),
	Mattermost("https://media.licdn.com/dms/image/C4E0BAQHKzpS-amYfmQ/company-logo_100_100/0/1652214403619?e=1691020800&v=beta&t=ewGOpBOQNkhlFGNkAgDU6yPvoTA7_YHzZIX_aQhKKXI"),
	Krinati("https://media.licdn.com/dms/image/C4E0BAQEX_7a6WLBtng/company-logo_100_100/0/1644579327341?e=1691020800&v=beta&t=WSJZZQuEn0t8_X2IiDgVEh3GuFP9EHL6PnfJDWVmIB4");
	
	 private final String url;

	    Urls(String url) {
	        this.url = url;
	    }

	    public static String getUrlByCompany(String companyName) {
	        for (Urls company : values()) {
	            if (company.name().equalsIgnoreCase(companyName)) {
	                return company.url;
	            }
	        }
	        return null;
	    }
}
