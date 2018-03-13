package hh.BookStore.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.BookStore.BookStore.domain.Category;
import hh.BookStore.BookStore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepoTest {

	@Autowired
	private CategoryRepository crepo;
	
	@Test
	public void findByNameShouldReturnCategory(){
		List<Category> categories = crepo.findByName("Sci-fi");
		
		assertThat(categories).hasSize(1);
	}
	@Test
	public void deleteCategory(){
		Category category = new Category("Test");
		crepo.save(category);
		assertThat(category.getCategoryid()).isNotNull();
		
		Long id = category.getCategoryid().longValue();
		crepo.delete(id);
		
		List<Category> categories = crepo.findByName("Test");
		assertThat(categories).hasSize(0);
	}
	
	@Test
	public void createNewCategory(){
		Category category = new Category("Test");
		crepo.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	
	
}
