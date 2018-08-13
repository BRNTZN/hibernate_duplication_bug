package app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Child {

	@Id
	private Long id;

	private String name;

	@ManyToOne
	private Parent parent;

	@OneToMany(mappedBy = "child", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<GrandChild> grandChildren;

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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public List<GrandChild> getGrandChildren() {
		return grandChildren;
	}

	public void setGrandChildren(List<GrandChild> grandChildren) {
		for (GrandChild grandChild : grandChildren) {
			grandChild.setChild(this);
		}
		this.grandChildren = grandChildren;
	}
}
