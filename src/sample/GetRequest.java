package sample;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class GetRequest{
	
public int RequestIdbyName(String summoner_name,String region) throws IOException, JSONException{
	
	
	URL url = new URL("https://"+region+".api.pvp.net/api/lol/"+region+"/v1.4/summoner/by-name/"+summoner_name+"?api_key=dd95adf6-d810-4e34-b669-e7719e199ab3");
	
	   
     URLConnection con = url.openConnection();
    InputStream in = con.getInputStream();
    String encoding = con.getContentEncoding();
    encoding = encoding == null ? "UTF-8" : encoding;
    String body = IOUtils.toString(in, encoding);
    System.out.println(body);
    
  
    JSONObject jsonObj = new JSONObject(body);
    JSONObject summoner = (JSONObject) jsonObj.get(summoner_name);
    int id =(Integer) summoner.get("id");
   // System.out.print("->ssss"+id);
    return id;
}



public void RequestbyID_CurrentGame(String ID,String region) throws IOException, JSONException{
	
	
	URL url = new URL("https://euw.api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/EUW/27298258?api_key=dd95adf6-d810-4e34-b669-e7719e199ab3");
	   
     URLConnection con = url.openConnection();
    InputStream in = con.getInputStream();
    String encoding = con.getContentEncoding();
    encoding = encoding == null ? "UTF-8" : encoding;
    String body = IOUtils.toString(in, encoding);
    System.out.println("--------");
    System.out.println(body);
    
  

    JSONObject jsonObj = new JSONObject(body);
    
    int g;
    
    
    
    for(g=0;g<5;g++){
    JSONObject participants = (JSONObject) (((JSONArray)jsonObj.get("participants")).get(g));
    String summoner_name =(String) participants.get("summonerName");
    System.out.print(summoner_name+"\n");
    }
    System.out.print("\n\n\n");
    
    for(g=5;g<10;g++){
        JSONObject participants = (JSONObject) (((JSONArray)jsonObj.get("participants")).get(g));
        String summoner_name =(String) participants.get("summonerName");
        System.out.print(summoner_name+"\n");
        }
    
    
    /*
    JSONObject jsonObj = new JSONObject(body);
   // JSONObject IDObj = (JSONObject) jsonObj.get(ID);
    JSONObject BansObj = (JSONObject) jsonObj.get("gameId");
    //int id =(Integer) BansObj.get("pickTurn");
    int id =(int) BansObj.get("gameId");
    System.out.print("->"+id);
    // id;
     * 
     */
}


}