package app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Parent {

	@Id
	private Long id;

	private String name;

	@OneToMany(mappedBy = "parent", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<Child> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		for (Child child : children) {
			child.setParent(this);
		}
		this.children = children;
	}
}
