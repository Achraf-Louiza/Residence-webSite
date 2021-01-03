package student.housing.ResidenceRental;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResidenceRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResidenceRentalApplication.class, args);
	}

	@Bean
	public CommandLineRunner ResidenceRental(ResidenceRepository residenceRepository) {
		return (args) -> {
			Residence res1 = new Residence("MIS pour jeunes actifs", 100, 30,
					400, 1000,
					"2-16, rue Theroigne de Mericourt - 75013 Paris",
					"\"La Maison Internationale de Séjour pour jeunes actifs a pour vocation d'héberger temporairement  un public jeune de 16 à 35 ans en insertion professionnelle (CDD, CDI, Stagiaires, Apprentissage, etc.)"
			);
			Residence res2 = new Residence("August Rodin", 60, 9,
					300, 765,
					"42 quarter rue de Sèvres - 75007 Paris",
					"Dans le 7ème arrondissement de Paris, tout près de l'hôtel Matignon, se trouve la résidence Auguste Rodin, sur la rue de Sèvres, après l'embranchement avec la rue de Babylone."
			);
			Residence res3 = new Residence("Quai de Loire", 26, 5,
					508, 896,
					"41 bis, quai de la Loire - 75019 Paris",
					"Ouverture Juillet 2016 Au bord du bassin de la Villette, résidence étudiante atypique offrant un cadre de vie privilégié dans un environnement animé à Paris."
			);
			Residence res4 = new Residence("Le palatino", 11, 3,
					411, 589,
					"20-36 allée Eric Chabeur - 75013 Paris",
					"Notre résidence Le Palatino est à proximité de l’Asfored, des écoles supérieures de journalisme, d’arts et par les transports en commun de toutes les universités parisiennes."
			);
			Residence res5 = new Residence("Rive-gauche Tolbiac", 60, 9,
					300, 765,
					"11 bis rue de la Vistule 75013 Paris",
					"Proche de Tolbiac et non loin de Jussieu ainsi que des autres grands campus universitaires, la résidence services 13eme rive gauche Tolbiac a été pensée pour offrir aux étudiants confort de vie et sécurité dans un cadre, unique, agréable et qualitatif."
			);

			Studio std1 = new Studio(18, 450, 400, 20, 5);

			residenceRepository.save(res1);
			residenceRepository.save(res2);
			residenceRepository.save(res3);
			residenceRepository.save(res4);
			residenceRepository.save(res5);
		};
	}
}
