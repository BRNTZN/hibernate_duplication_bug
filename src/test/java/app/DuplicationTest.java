package app;

import app.entity.Child;
import app.entity.GrandChild;
import app.entity.Parent;
import app.repository.ParentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DuplicationTest {

	@Autowired
	private ParentRepository parentRepository;

	@Test
	public void duplicationTest() {
		assertNotNull(parentRepository);

		Parent parent = new Parent();
		parent.setId(Long.valueOf(1));
		parent.setName("Patrick");

		Child child = new Child();
		child.setId(Long.valueOf(2));
		child.setName("Charlie");

		GrandChild grandChild = new GrandChild();
		grandChild.setId(Long.valueOf(3));
		grandChild.setName("Gerta");

		GrandChild grandChild2 = new GrandChild();
		grandChild2.setId(Long.valueOf(4));
		grandChild2.setName("Germaine");

		GrandChild grandChild3 = new GrandChild();
		grandChild3.setId(Long.valueOf(5));
		grandChild3.setName("Gina");

		child.setGrandChildren(Arrays.asList(grandChild, grandChild2, grandChild3));
		parent.setChildren(Arrays.asList(child));

		parentRepository.save(parent);

		Parent foundParent = parentRepository.findById(Long.valueOf(1)).get();
		System.out.println(foundParent.getName());
		System.out.println(foundParent.getChildren().size());
		System.out.println(foundParent.getChildren().get(0).getName());
		System.out.println(foundParent.getChildren().get(1).getName());
		System.out.println(foundParent.getChildren().get(2).getName());

		// The child charlie is now added 3x (always as many as there are grandchildren)
		assertEquals(1, foundParent.getChildren().size());
	}

}
