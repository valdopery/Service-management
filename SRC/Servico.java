import java.io.Serializable;
import java.text.DecimalFormat;

public class Servico implements Serializable {
	protected String area, tipoServico;
	protected float preco;
	protected DecimalFormat mt;

	public Servico(String area, float preco, String tipoServico) {
		this.area = area;
		this.tipoServico = tipoServico;
		this.preco = preco;
		mt = new DecimalFormat("###,####.## Mt");
	}

	public Servico() {
		this("", 0, "");
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String toString() {
		return String.format("%c%19s%c%27s%c%12s%c", '|', area, '|',
				tipoServico, '|', mt.format(preco), '|');
	}
}