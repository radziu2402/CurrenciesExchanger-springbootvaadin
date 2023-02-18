
package pl.edu.currenciesexchanger.Dto;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "motd",
    "success",
    "query",
    "info",
    "historical",
    "date",
    "result"
})
@Generated("jsonschema2pojo")
public class RateModel {

    @JsonProperty("motd")
    private Motd motd;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("query")
    private Query query;
    @JsonProperty("info")
    private Info info;
    @JsonProperty("historical")
    private Boolean historical;
    @JsonProperty("date")
    private String date;
    @JsonProperty("result")
    private BigDecimal result;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("motd")
    public Motd getMotd() {
        return motd;
    }

    @JsonProperty("motd")
    public void setMotd(Motd motd) {
        this.motd = motd;
    }

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("query")
    public Query getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(Query query) {
        this.query = query;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("historical")
    public Boolean getHistorical() {
        return historical;
    }

    @JsonProperty("historical")
    public void setHistorical(Boolean historical) {
        this.historical = historical;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("result")
    public BigDecimal getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "RateModel{" +
                "motd=" + motd +
                ", success=" + success +
                ", query=" + query +
                ", info=" + info +
                ", historical=" + historical +
                ", date='" + date + '\'' +
                ", result=" + result +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
