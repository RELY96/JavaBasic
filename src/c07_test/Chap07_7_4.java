package c07_test;

//※추가 문제 : 채널, 볼륨의 범위를 아래 상수의 범위로 제한하도록 작성
//※7_5 : 이전 채널 매서드 추가(새로운 채널이 들어올때마다 이전값을 보관)

class MyTv {
	private boolean isPowerOn; // private 제어자 붙이기
	// 통상적으로 맴버변수명에서 두번째 알파벳은 대문자로 안씀(get,set뒤 대문자 오는거랑 헷갈릴 수 있어서)
	// (ex:tEst)
	private int channel;
	private int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHNNEL = 100;
	final int MIN_CHNNEL = 1;
	
	//7-5 맴버변수(이전 채널값 저장 목적)
	private int prevChannel;

	// ---getter setter------------------//

	public void setIsPowerOn(boolean isPowerOn) {
		// "어디서나public" 읽고 쓸 수 있는 get~, set~
		// get,set 뒤 첫글자 대문자로 쓰기 기억!
		this.isPowerOn = isPowerOn;
	}
	public boolean getIsPowerOn() {
		return this.isPowerOn;
	}
	// ------------------//
	public void setChannel(int channel) { //매개변수에 prev채널을 넣는 매서드를 따로 만들어서 channel=prevchannel해줄수도 있음
		if (channel < MIN_CHNNEL || channel > MAX_CHNNEL) {
			System.out.println("** 채널이 범위를 벗어났습니다");
		}
		else {
			prevChannel =this.channel;
			//-> 7-5 채널이 변경되기 전에 현재 채널의 값을 prevChannel에 보관
			this.channel = channel;
		}
	}

	public int getChannel() {
		return this.channel;
	}

	// ------------------//
	public void setVolume(int volume) {
		if (volume >= MIN_VOLUME && volume <= MAX_VOLUME) {
			this.volume = volume;
		} else {
			System.out.println("** 볼륨이 범위를 벗어났습니다");
		}
	}
	public int getVolume() {
		return this.volume;
	}

	// 7-5 이전 채널 매서드==========================//
	// setter를 이용해 channel에 preChannel을 set만 해주면 됨
	
	public void gotoPrevChannel() {
		setChannel(prevChannel);
		//1.채널에 이전 채널 prev넣어주기 -> 미리 만들어진 setter channel이용해서 prev를 매개변수로 만들어주면됨

		//2.채널이 변경될 때, 현재 채널의 값을 prev채널에 보관하기(채널이 변경될때니까, setChannel에서 처리)
		// => prevchannel=channel;
	}
	
	//==============================================//
}
public class Chap07_7_4 {

	public static void main(String[] args) {
		MyTv t = new MyTv();

		t.setChannel(10);
		System.out.println("CH : " + t.getChannel()); //10
		t.setChannel(20);
		System.out.println("CH : " + t.getChannel()); //20, prev=10보관
		
		// 7-5 Test
		t.gotoPrevChannel(); //prev에 있던 10이 channel로 보관, 10, prev에는 20보관
		System.out.println("CH : " + t.getChannel());
		t.gotoPrevChannel(); //prev에 있던 20이 channel로 보관, 20, prev에는 10보관
		System.out.println("CH : " + t.getChannel());
		
		//----------오류 테스트-----------//
//		MyTv t2 = new MyTv();
//		t2.setChannel(0);
//		System.out.println("CH : " + t2.getChannel());
//		t2.setVolume(108);
//		System.out.println("VOL : " + t2.getVolume());
		//---------7-5 Test-----------//
		
		
	} // main

} // class
