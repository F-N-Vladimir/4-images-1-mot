CREATE TABLE puzzles (
    id SERIAL PRIMARY KEY,
    mot VARCHAR(50) NOT NULL, 
    image1_path VARCHAR(255), 
    image2_path VARCHAR(255),
    image3_path VARCHAR(255),
    image4_path VARCHAR(255)
);

INSERT INTO puzzles (mot, image1_path, image2_path, image3_path, image4_path)
VALUES (
    'AMIE',
    'C:/Users/Admin/OneDrive - Université Des Mascareignes/Bureau/Jeux 4 img & 1 mot/chat1.jpg',
    'C:/Users/Admin/OneDrive - Université Des Mascareignes/Bureau/Jeux 4 img & 1 mot/chat2.jpg',
    'C:/Users/Admin/OneDrive - Université Des Mascareignes/Bureau/Jeux 4 img & 1 mot/chat3.jpg',
    'C:/Users/Admin/OneDrive - Université Des Mascareignes/Bureau/Jeux 4 img & 1 mot/chat4.jpg'
);
