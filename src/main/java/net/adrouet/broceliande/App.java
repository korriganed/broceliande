package net.adrouet.broceliande;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.adrouet.broceliande.algo.Parameter;
import net.adrouet.broceliande.algo.RandomForest;
import net.adrouet.broceliande.bean.Passenger;
import net.adrouet.broceliande.util.CsvUtils;

public class App {

	private static Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		List<Passenger> train = readPassager();

		Parameter p = new Parameter.Builder().build();
		RandomForest<Passenger, Integer> forest = new RandomForest<>(p);

		for (int i = 0; i < 10; ++i) {
			forest.fit(train);
			long count = train.stream().filter(pa -> forest.predict(pa).equals(pa.getResult())).count();
			LOG.info("Success rate: {}%", String.format("%.2f", count * 100 / (double) train.size()));
		}

		List<ImmutablePair<String, Double>> rank = forest.importance();
		for (ImmutablePair<String, Double> e : rank) {
			LOG.info("Importance: feature {} - {}", String.format("%.3f", e.getRight()), e.getLeft());
		}

	}

	public static List<Passenger> readPassager() throws Exception {
		List<Passenger> train = CsvUtils.csvToBean("train.csv", Passenger.class);
		fixMissingData(train);
		return train;


	}

	private static void fixMissingData(List<Passenger> train) {
		train.forEach(p -> {
			if (p.getPclass() == null) p.setPclass(3);
			if (p.getAge() == null) p.setAge(23);
			if (p.getFare() == null) p.setFare(8.05);
			if (p.getEmbarked() == null || p.getEmbarked().isEmpty()) p.setEmbarked("S");

			String name = p.getName();
			if (name.matches(
					".*Don.*|.*Lady.*|.*Countess.*|.*Capt.*|.*Col.*|.*Don.*|.*Dr.*|.*Major.*|.*Rev.*|.*Sir.*|.*Jonkheer.*")) {
				p.setTitle("rare");
			} else if (name.matches(".*Mlle.*|.*Ms.*")) {
				p.setTitle("Miss");
			} else if (name.matches(".*Mrs.*|.*Mme.*")) {
				p.setTitle("Mrs");
			} else {
				p.setTitle("Mr");
			}
		});
	}
}
