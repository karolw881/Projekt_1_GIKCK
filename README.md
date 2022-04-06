# Projekt_1_GIKCK
lab1_4

## Aplikacja GUI ##

## Laczy ona laboratoria od 1 do 4 ##
* lab1 (Obraz)
* lab2 (gra)
* lab3 (inicjaly)
* lab4 (wizualizacja 3D kubka , lyzki i czajnika )

## 100 % JAVA ##

## Opis klas ##

#Glowne:

1) My_frame - odpowiedzialna za glowne GUI (MENU)
2) Main - klasa glowna , w ktorej uruchamiamy klase My_frame , a takze zmienamy wielkosc zdjecia
--------------------------------------------------------------------------------------------------------

#lab1 :
 	<-- Fraktal -->  
 1) wykorzystuje ona krzywa kocha  
 2) button powrotu z fraktalu do menu uaktywnia sie dopiero po zakonczeniu rysunku 

--------------------------------------------------------------------------------------------------------
#lab2:
1) wykorzystane pomoce z zajec :  https://zetcode.com/javagames/

<-- Snake --> 

1)   Dodane Menu_snake , dodane dodatkowy owoc do zbierania przez snake (trzeba najechac na lewy gorny pixel zdjecia cytrynki  by zebrac cytrynke)  ,  dodane prostokaty (jeśli glowa snake w nia uderzy przegrywamy gre) 
	
	
<-- Tetris --> 
2)dodane napis stop i menu dzieki ktorym wiadomo jaki klawisz wcisnac by wrocic do glownego menu 
3) Problemy : podczas zamykania gry pojawia sie glowne menu , natomiast tetris sie nie zamyka :(
4 ) Klasy: Board , Board_T , Menu_snake , Snake , Tetris , Shape 

--------------------------------------------------------------------------------------------------

#lab3:
<--Inicjaly -->
1)wykorzystany algorytnm :  https://www.youtube.com/watch?v=uiHzKt_HPds&t=237s
2)klasa Bezier 

---------------------------------------------------------------------------------------------------

#lab4:
<-- 3d -->
1) Wizualizacja 3 wymiarowa kubka , czajnika , lyzki 
2) wykorzystana applikacja ParaView 5.10.1
3) Zrobiony ScreenShot i wstawiony do Api , niestety nie udala sie wizualizacja 3D Java 
4)Generowalem punkty a nastepnie te punkty(w projekcie nazwane plik_po_wzorze_czajnik , plik_po_wzorze_kubek , plik_po_wzorze_lyzka)
skopiowane do ParaView 
5)klasy : Bezier3d , panelbezier3d , Point
6)pliki_po_wzorze_czajnik sa tworzone dopiero w momencie wykonania aplikacji , byly za duze (18mb) i repozytorium na githubie nie chcialo mi ich dodac 
