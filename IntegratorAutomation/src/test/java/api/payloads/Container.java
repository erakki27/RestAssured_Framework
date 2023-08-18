package api.payloads;

import java.util.ArrayList;
import java.util.List;

public class Container {

	 String container_description;
	 String container_name;
     String container_theme_color;
     String container_type;
     List<Integer> tagIds = new ArrayList<Integer>();
     
     
     public List<Integer> getTagIds() {
		return tagIds;
	}
	public void setTagIds(List<Integer> tagIds) {
		this.tagIds = tagIds;
	}
	public String getContainer_description() {
		return container_description;
	}
	public void setContainer_description(String container_description) {
		this.container_description = container_description;
	}
	public String getContainer_name() {
		return container_name;
	}
	public void setContainer_name(String container_name) {
		this.container_name = container_name;
	}
	public String getContainer_theme_color() {
		return container_theme_color;
	}
	public void setContainer_theme_color(String container_theme_color) {
		this.container_theme_color = container_theme_color;
	}
	public String getContainer_type() {
		return container_type;
	}
	public void setContainer_type(String container_type) {
		this.container_type = container_type;
	}
	
}
