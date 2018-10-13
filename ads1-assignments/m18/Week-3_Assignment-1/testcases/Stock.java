public final class Stock {

	private String stockName;

	private double stockRate;

	Stock(){

	}

	Stock(final String theStockName, final double theStockRate) {
		this.stockName = theStockName;
		this.stockRate = theStockRate;
	}

	public double getStockRate(final String stockOf) {
		return this.stockRate;
	}

}