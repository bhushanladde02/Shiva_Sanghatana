package  shivasanghatana.onine.com.pojo;

public class DataShiva {
  public String headerValue;
  public String newsDetails;
  public String id;
  public String authValue;
  public String lastUpdatedDt;
  public String person;
  
public DataShiva(String headerValue, String newsDetails, String id,String authValue, String lastUpdatedDt, String person) {
	super();
	this.headerValue = headerValue;
	this.newsDetails = newsDetails;
	this.id = id;
	this.authValue = authValue;
	this.lastUpdatedDt = lastUpdatedDt;
	this.person = person;
}
public DataShiva() {
	super();
	// TODO Auto-generated constructor stub
}
public String getPerson() {
	return person;
}
public void setPerson(String person) {
	this.person = person;
}
public String getLastUpdatedDt() {
	return lastUpdatedDt;
}
public void setLastUpdatedDt(String lastUpdatedDt) {
	this.lastUpdatedDt = lastUpdatedDt;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getAuthValue() {
	return authValue;
}
public void setAuthValue(String authValue) {
	this.authValue = authValue;
}
public String getHeaderValue() {
	return headerValue;
}
public void setHeaderValue(String headerValue) {
	this.headerValue = headerValue;
}
public String getNewsDetails() {
	return newsDetails;
}
public void setNewsDetails(String newsDetails) {
	this.newsDetails = newsDetails;
}
@Override
	public String toString() {
		
		return "<tr><td><b>"+headerValue+":</b><br/>"+newsDetails+"<br/><b> तारीख:</b>"+lastUpdatedDt.split("/")[2]+"/"+lastUpdatedDt.split("/")[1]+"/"+lastUpdatedDt.split("/")[0]+"</td></tr>";
	}

  
}
