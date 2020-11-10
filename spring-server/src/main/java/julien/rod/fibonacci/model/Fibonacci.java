package julien.rod.fibonacci.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Fibonacci
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-10T14:22:17.308Z")




public class Fibonacci   {
  @JsonProperty("result")
  @Valid
  private List<String> result = new ArrayList<String>();


  public Fibonacci(String maxValue){
    try {
      double max = Double.parseDouble(maxValue);
      if(max < 1) throw new NumberFormatException();
      int first = 0;
      int second = 1;
      result.add(Integer.toString(first));
      result.add(Integer.toString(second));
      for(;(first + second) <= max;){
        second += first;
        first = second - first;
        result.add(Integer.toString(second));
      }
    } catch (NumberFormatException nfe) {
      result.add("The request is not valid.");
    }

  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public List<String> getResult() {
    return result;
  }

  public void setResult(List<String> result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fibonacci fibonacci = (Fibonacci) o;
    return Objects.equals(this.result, fibonacci.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fibonacci {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

