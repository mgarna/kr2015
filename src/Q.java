public class Med {

	private String name = "";
	private String country = "";
	private String group = "";
	private String data = "";
	private String amount = "";
	private String price = "";

	public Med( String name, String country, String group, String data, String amount, String price){

		this.name = name;
		this.country = country;
		this.group = group;
		this.data = data;
		this.amount = amount;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAll(){
		return "" +""+this.name +""+ this.country +""+ this.group +""+ this.data +""+ this.amount+""+ this.price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Med med = (Med) o;

		if (name != null ? !name.equals(med.name) : med.name != null) return false;
		if (country != null ? !country.equals(med.country) : med.country != null) return false;
		if (group != null ? !group.equals(med.group) : med.group != null) return false;
		if (data != null ? !data.equals(med.data) : med.data != null) return false;
		if (amount != null ? !amount.equals(med.amount) : med.amount != null) return false;
		return price != null ? price.equals(med.price) : med.price == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (country != null ? country.hashCode() : 0);
		result = 31 * result + (group != null ? group.hashCode() : 0);
		result = 31 * result + (data != null ? data.hashCode() : 0);
		result = 31 * result + (amount != null ? amount.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Med{" +
				"name='" + name + '\'' +
				", country='" + country + '\'' +
				", group='" + group + '\'' +
				", data='" + data + '\'' +
				", amount='" + amount + '\'' +
				", price='" + price + '\'' +
				'}';
	}
}
