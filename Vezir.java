
public class Vezir extends Item{

	public Vezir(String renk, int puan) {
		this.renk = renk;
		if(renk == "siyah")
			this.amblem = "v";
		else
			this.amblem = "V";
		this.puan = puan;
	}

	public boolean hareketKabiliyeti(int baslangicSatir, int baslangicSutun, int hedefSatir, int hedefSutun, Board board, Player player) {
		
		if( ( baslangicSutun == hedefSutun || baslangicSatir == hedefSatir ) || ( Math.abs(hedefSatir-baslangicSatir) == Math.abs(hedefSutun-baslangicSutun) ) )
			return true;
		else
			return false;
	
	
	}
	
	
	
	
	
	
}
