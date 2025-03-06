# JaajvaPrintempsSpring

- Cloner le dépot suivant :

https://github.com/iliesovni/JaajvaPrintempsSpring

- Créer la base de données grâce au SQL ci-dessous :

CREATE DATABASE motivation_chat;

- Modifier le fichier application.properties dans les 2 projets pour correspondre aux information relatives à la bdd :

spring.datasource.url=jdbc:mysql://localhost:port/motivation_chat
spring.datasource.username=nom
spring.datasource.password=mot de passe

- Importer un petit jeu de données pour les quotes à afficher :

INSERT INTO quote (content, author) VALUES
('Le succès, c\'est tomber sept fois, se relever huit.', 'Proverbe japonais'),
('N\'attends pas que les opportunités viennent à toi. Crée-les.', 'Chris Grosser'),
('La seule limite à notre épanouissement de demain est nos doutes d\'aujourd\'hui.', 'Franklin D. Roosevelt'),
('Fais de ta vie un rêve, et d\'un rêve, une réalité.', 'Antoine de Saint-Exupéry'),
('Tout semble toujours impossible jusqu\'à ce que ce soit fait.', 'Nelson Mandela'),
('Ne regarde pas l\'escalier, monte juste la première marche.', 'Martin Luther King Jr.'),
('Le meilleur moment pour planter un arbre, c\'était il y a 20 ans. Le deuxième meilleur moment, c\'est maintenant.', 'Proverbe chinois'),
('Travaille dur en silence, laisse ton succès faire du bruit.', 'Frank Ocean'),
('Ne laisse jamais les ombres d’hier obscurcir la lumière de demain.', 'Walt Disney'),
('Chaque jour est une nouvelle chance d’y arriver.', 'Inconnu');

- Lancer le projet QuoteApi puis le projet ChatApp dans eclipse ou un autre IDE

- Utiliser la route :

http://localhost:8081/chat/send