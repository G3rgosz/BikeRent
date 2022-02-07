USE tanar_bikerent;

INSERT INTO brands( brand ) VALUES
( "KTM" ),
( "XFACT" ),
( "CSEPEL" ),
( "TREK" ),
( "SCOTT" );

INSERT INTO brakes( brake ) VALUES
( "tárcsa" ),
( "v-fék" ),
( "patko" ),
( "kontra" );

INSERT INTO designs( design ) VALUES
( "női" ),
( "férfi" );

INSERT INTO sizes( size ) VALUES
( "10" ), 
( "20" ), 
( "22" ), 
( "24" ), 
( "28" );

INSERT INTO types( type ) VALUES
( "országúti" ),
( "montenbájk" ),
( "városi" ),
( "bmx" );
 	
INSERT INTO bikes( code, speed, brand_id, brake_id, size_id, design_id, type_id ) VALUES
( "12345", 6, 2, 3, 1, 1, 2 ),
( "12345", 12, 4, 1, 3, 1, 3 ),
( "12345", 18, 1, 2, 3, 2, 3 ),
( "12345", 21, 5, 3, 2, 2, 1 ),
( "12345", 1, 3, 4, 4, 1, 3 );

INSERT INTO renters( name, email, phone, address, identity ) VALUES
( "Béla", "bela@bela.hu", "123456789", "Bélapátfalva Béla utca 1", "987654321" ),
( "Pista", "pista@pista.hu", "123456789", "Pistapátfalva Pista utca 1", "987654321" ),
( "Lajos", "lajos@lajos.hu", "123456789", "Lajospátfalva Lajos utca 1", "987654321" ),
( "Margit", "margit@margit.hu", "123456789", "Margitpátfalva Margit utca 1", "987654321" ),
( "János", "jani@jani.hu", "123456789", "Jánospátfalva János utca 1", "987654321" );

INSERT INTO rents( startdate, enddate, deposit, renter_id, bike_id ) VALUES
( "2021-01-15", "2021-01-20", 20000, 3, 3 ),
( "2021-01-30", "2021-02-20", 25000, 2, 4 ),
( "2021-02-10", "2021-02-25", 30000, 1, 2 ),
( "2021-04-08", "2021-04-22", 10000, 4, 1 ),
( "2021-05-11", "2021-05-31", 40000, 5, 5 );
