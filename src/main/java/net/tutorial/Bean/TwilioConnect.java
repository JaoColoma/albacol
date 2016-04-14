package Bean;

import Servlet.TwilioServlet;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

public class TwilioConnect {
    
    String username = null, password = null;
    String accountSID = null, authToken = null;
	
	public TwilioConnect(){
		try{
			setCreds();
		}catch (Exception e){
			
		}
	}
    
    private void setCreds()throws Exception{
        Map<String, String> env = System.getenv();
        
        if(env.containsKey("VCAP_SERVICES")){ 
            JSONParser parse = new JSONParser();
            JSONObject v_serv = (JSONObject) parse.parse(env.get("VCAP_SERVICES"));
            JSONObject service = null;
            
            
            for (Object key : v_serv.keySet()) {
                String keyStr = (String) key;
                if (keyStr.toLowerCase().contains("user-provided")) { 
                    service = (JSONObject) ((JSONArray) v_serv.get(keyStr)).get(0);
                    break;
                }
            }
            
            if (service != null) { 
                JSONObject creds = (JSONObject) service.get("credentials");
                this.accountSID = (String) creds.get("accountSID");
                this.authToken = (String) creds.get("authToken");
            }
            else {
                throw new Exception("Twilio service not found");
            }
        }
        else{ 
            throw new Exception("Error: VCAP_SERVICES not found");
        }
    }
    
    public String getAcctSID(){
        return accountSID;
    }
    
    public String getAuthToken(){
        return authToken;
    }
}
