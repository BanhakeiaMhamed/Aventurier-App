package aventurier.jeu.banhakeia.utilsTesUnit;

import aventurier.jeu.banhakeia.utils.GamePlayUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;



import static org.assertj.core.api.Assertions.assertThat;


class ControllerTest {
	GamePlayUtils utils = new GamePlayUtils();

	@Test
	void itShouldGenerateRandomValuesOfOneAndX() {
		//given
		int size = 6;
		//when
		String randomValue = utils.generateRandomValues(size);
		//then
		assertThat(randomValue.chars().anyMatch(n-> n=='x'));
		assertThat(randomValue.chars().anyMatch(n-> n=='0'));
	}

	@Test
	void itShouldNotBeNull(){
		GamePlayUtils utils = new GamePlayUtils();

		//given
		int defaulValue = 8;
		//when
		String randomValue = utils.generateRandomValues(defaulValue);
		//then
		Assert.notNull(randomValue);

	}
}
