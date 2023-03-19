
public class Player {

	String renk;
	int puan = 0;
	
	
	
	public Player(String renk) {
		this.renk = renk;
	}



	public int getPuan() {
		return this.puan;
	}

	public void addPuan(int add) {
		this.puan = this.puan + add;
	}
	
	public void tasOyna(int baslangicSatir, int baslangicSutun, int hedefSatir, int hedefSutun, Board board) {
		board.oyunTahtasi[hedefSatir][hedefSutun] = board.oyunTahtasi[baslangicSatir][baslangicSutun];
		Item bos = new Item("-");
		board.oyunTahtasi[baslangicSatir][baslangicSutun] = bos;
	}
	
	
	
	
	
	
	
	
	
	
	
}
