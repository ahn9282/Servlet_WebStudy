package jsp_ajs_game_lotto.vo;

public class RspVO {

	private String rsp = null;
	private static String[] arrRsp = {"가위","바위","보"};
	public String img = "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmedia.istockphoto.com%2Fvectors%2Fcute-boy-character-icon-vector-id811610182%3Fk%3D6%26m%3D811610182%26s%3D170667a%26w%3D0%26h%3DWU47bSJA9Qo5qHB2nymQIpySddVoivzKVRSrjMa-ol8%3D&type=a340";
	private static String[] arrImages = {
			"http://49.247.158.208:9999/hjs/img/scissor.f9ef898c.jpg",
			"http://49.247.158.208:9999/hjs/img/scissor.f9ef898c.jpg",
			"http://49.247.158.208:9999/hjs/img/paper.0b032424.jpg"
			};
	
	public RspVO() {
		this.img="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmedia.istockphoto.com%2Fvectors%2Fcute-boy-character-icon-vector-id811610182%3Fk%3D6%26m%3D811610182%26s%3D170667a%26w%3D0%26h%3DWU47bSJA9Qo5qHB2nymQIpySddVoivzKVRSrjMa-ol8%3D&type=a340";
		rsp=arrRsp[(int)(Math.random()*3) ];
		
	}
	public RspVO(String rsp) {
		if(rsp==null) {
			this.rsp="가위";
			img="http://49.247.158.208:9999/hjs/img/scissor.f9ef898c.jpg";
		}
		this.rsp=rsp;
	}
	
	public String getResult(RspVO you) {
		 String result = "비겼습니다.";
	      
	      if(this.rsp.equals(you.getRsp())) {
	         return result;
	      }
	      
	      
	      if(this.rsp.equals("가위") && you.getRsp().equals("바위") ) {
	    	  
	         result = "당신이 이겼습니다.";
	      }else if(this.rsp.equals("가위") && you.getRsp().equals("보") ) {
	         result = "당신이 졌습니다.";
	      }else if(this.rsp.equals("바위") && you.getRsp().equals("보") ) {
	         result = "당신이 이겼습니다.";
	      }else if(this.rsp.equals("바위") && you.getRsp().equals("가위") ) {
	         result = "당신이 졌습니다";
	      }else if(this.rsp.equals("보") && you.getRsp().equals("가위") ) {
	         result = "당신이 이겼습니다.";
	      }else if(this.rsp.equals("보") && you.getRsp().equals("바위") ) {
	         result = "당신이 졌습니다";
	      }   
	         
	      return result;

	   }
	
public String getImg() {
	if(this.rsp.equals("가위")) {
		img="http://49.247.158.208:9999/hjs/img/scissor.f9ef898c.jpg";
	}else if(this.rsp.equals("바위")) {
		img="http://49.247.158.208:9999/hjs/img/rock.8b39a13f.jpg";
		
	}else if(this.rsp.equals("보")) {
		img="http://49.247.158.208:9999/hjs/img/paper.0b032424.jpg";
		
	}else {
		img="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmedia.istockphoto.com%2Fvectors%2Fcute-boy-character-icon-vector-id811610182%3Fk%3D6%26m%3D811610182%26s%3D170667a%26w%3D0%26h%3DWU47bSJA9Qo5qHB2nymQIpySddVoivzKVRSrjMa-ol8%3D&type=a340";

	}
	return img;
}
	
	
	public String getRsp() {
		return rsp;
	}
	public void setRsp(String rsp) {
		this.rsp = rsp;
	}
	public static String[] getArrRsp() {
		return arrRsp;
	}
	public static void setArrRsp(String[] arrRsp) {
		RspVO.arrRsp = arrRsp;
	}
	
}
