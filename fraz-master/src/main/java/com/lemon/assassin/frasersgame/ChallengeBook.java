package com.lemon.assassin.frasersgame;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import  java.util.Random;

public class ChallengeBook {

    public ArrayList<JSONObject> mChallenges;

    {
        try {
            mChallenges = readTheRules();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int counter = 0;


    public String getChallenge(Boolean forward) throws IOException, JSONException {
        String challenge = "";

        if (counter == 0){
            mChallenges = readTheRules();
        }

        if(forward) {
            counter++;
            challenge = mChallenges.get(counter).getString("rule");
            if (counter == mChallenges.size()) {
                counter = 0;
            }
            return challenge;
        }
        else if (counter > 0) {
            counter--;
            challenge = mChallenges.get(counter).getString("rule");
            return challenge;
        }
        else return "You need to pick next";
    }

    private static ArrayList<JSONObject> readTheRules() throws IOException {
        ArrayList<JSONObject> easy = new ArrayList<>();
        ArrayList<JSONObject> allOthers = new ArrayList<>();

        //FileReader fr = new FileReader("rules.txt");

        //BufferedReader reader = new BufferedReader(fr);
        BufferedReader reader = new BufferedReader(new StringReader(rulesString));
        String ruleName;
        while ((ruleName = reader.readLine()) != null){
            try {
                JSONObject current = new JSONObject(ruleName);
                if(current.getString("difficulty").equals("Easy")){
                    easy.add(current);
                }
                else{
                    allOthers.add(current);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        reader.close();

        Collections.shuffle(easy);
        ArrayList<JSONObject> starters = new ArrayList<>(easy.subList(0, 20));
        allOthers.addAll(easy.subList(21, easy.size() -1));
        Collections.shuffle(allOthers);
        starters.addAll(allOthers);

        return starters;
    }

    public static String rulesString ="{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Everyone swap an item of clothing with someone\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Propose marriage to someone, they now drink when you do, roleplay is encouraged\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Left hand only until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - A parcel is at the door, everyone needs to go to the door and sign for it on this card\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Group selfie, take a photo of everyone in the room\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Hold hands with someone until the next bomb, literally nothing can break this bond\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Raw Sauce, the drawer gets to do a shot of sauce, ketchup, mayo, ect\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Cheerleader pyramid, let's go\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The drawer cannot speak until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Three monkeys; choose 3 people to see no evil, hear no evil, speak no evil. Until the next bomb, cheeky monkeys\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I'm not an alcoholic, hold an intervention for the drawer, they may only have water until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - 10 second upside down drink for the drawer, don't you dare vomit, do this outside\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Someone loves hugs, hug everyone in the room\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Everyone say something nice about the person to their left, wholesome to the max\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Change seats, end all conversations, find a new group to speak to\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Parrot, the drawer can be challenged to repeat, word for word, what you just said until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The Human Jukebox, the music can be turned off and the drawer needs to give a rendition of a song\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Disney Princess,  you are in love with the first person you see after drawing this card, love at first sight no lying\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - You are a Mannequin, you need to keep any pose someone puts you into until the next bomb, let's not be lewd boys\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Lost in space, you just arrived from another planet and do not understand human conventions, ask about everything that happens until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Read all about it, come up with a fake news story and interview people about it, mime a microphone, if people have no comment they get to drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : This card is a secret, convince everyone to do a group task or be caught spy\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Phones on the table, first one to pick theirs up reads out what is says and downs their drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The family dog,  say woof at the end of each sentence and remember to fetch until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The family cat, say meow at the end of sentences and remember to lick your paw until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : There's something outside, is it a bird, is it a plane, describe something incredible you see, if people walk away from the window take a drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Your nerdy hobby just became cool, act like you knew it would the whole time and talk about it at every opportunity until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The police just arrived, everyone needs to go to the door and greet them and apologies for the noise\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Cluedo, the person to your right was just murdered, they lie on the floor and you need to determine a culprit, interview the room\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -It's past everyone's bedtime, get everyone to bed before the end of the song\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Poverty claims another victim, get at least £1 in spare change before the end of the song\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Have you seen my pet snake, I swear it's somewhere in this house, look for it until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : I just hate this song, get the next song changed early or receive a punishment\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I'm kind of Internet famous, only talk about why until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Conspiracy theorist, chemical trails and gay frogs, only talk about conspiracy theories until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Take a chill pill, you are the dude until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium -  Auction off something in the flat to the highest bidder, we bid drinks and it needs to be left and the end of the night, winner needs to hold onto it until the next bomb\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Start a drawing on this card, pass it round until it's finished, no genitals or you can stand outside until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Not to play to stereotypes but you will, choose one to be until the next bomb don't be too racist\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - You just got out of prison, talk about your experiences in the system until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium -  Narrate everything you see as David Attenborough until the room tells you to stop\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Mr steal your girl, hijack a conversation and push someone out, as soon as they leave apologise for being a prick\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Pick a target,  tap them on the shoulder 3 times without them asking to see this card, you have until the next bomb\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Self support,set up chairs to do the trick where you lie on each other but still manage to stay supported, ask if unknown\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - You are a magician until the next bomb, show us a magic trick\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - John Doe, only speak in the third person until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Here try this, everyone swap drinks with someone\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : No, I am spartacus, anyone who does do the thing drinks\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Pitch perfect, make acapella song, get the everyone involved\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - A night to remember, take a selfie with everyone here\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Back in my day, everything was so different back when you were young, tell people about it until the next bomb\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Lord of thunder, play thunderstruck by acdc with everyone in the room, one at a time drink until the next thunder\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret :Assassin, you target is to your left, subtly kill them, if anyone but them notices you lose\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Chinese whisper around the room, if the last man doesn't get it the room drinks, the names not racist okay\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Sticky fingers, everything inanimate you touch is now stuck to you, they need to stay with you until the next bomb, use duct tape if needed\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - You've been slighted, challenge someone to a duel, fire at one another and take a drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I know you from somewhere, seem really interested in where the person to you right has been\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - You are an American, if you yell america everyone must respond with fuck yeah or drink\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Categories, set one and anyone who can't think of one drinks, no repeats\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Sign language interpreter, interpret what the person talking to you is saying in sign language until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I'm so lonely, always be in a conversation,  if you see someone not talking you need to involve them\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Guys I've prepared a monologue for my audition, perform this for everyone in the room\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Everyone needs the same number of clothes on their top as on bottom\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Maintain eye contact, do not break eye contact with anyone until they do it to you first\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Challenge everyone to a staring contest\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Lipsync, choose a song and lip sync it for everyone\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - No one can use real names for the next 2 bombs\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Secret : don't speak, subtly lick everyone in the room\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Kleptomaniac, get something from everyone in the room, maybe a phone number ;p\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Pick up lines, everyone needs to give one, let's help any of you singles out there\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Limbo dance, grab a broom it's a competition\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Let's recreate a vine, choose a vine and get everyone to help you recreate it\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Show everyone your ballroom dancing skills, grab a partner and show everyone your moves\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Yeah I can beatbox, and I can prove it to all of you right now\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Of course I know how to freestyle rap, everybody listen up to my set\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Boy do I have a product for you, give your elevator pitch to the group promoting your newest company or product\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - A toast, give a toast to the magnificent family before you\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - This card is now your responsibility, if you turn up to an event without it you get a penalty\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : Convince everyone that this card is blank and you should be allowed to draw another\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I always knew there was an artist in the family, grab a sketch book and a pencil and draw a portrait of someone, if it's good it might go on the fridge\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I'm always on a hot streak, players can bet you drinks to perform a simple action, you can pass and drink or succeed and make them drink\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Comedian, tell us all a joke, if no one laughs you drink\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Build a card pyramid at least 2 layers high\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Hands up question: losing team drinks\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Musical chairs, you are in charge of the music, play until there is a winner\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Slip an obscure word into a conversation at least 3 times, penalty if anyone notices\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The floor is made of lava, if you stand on my furniture with shoes you get a penalty\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I know this song, elect a song and if you can't sing all the words you get a punishment\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Thumb war, select a target and loser drinks\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Question master, if you ask a question, the answer should always be fuck you question master\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium -  Straight up just eat your card, you can share but literally eat it\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Honey I’m home, everyone leave the house and reenter greeting your spouse as you arrive  home from a hard day\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Bartender, you must serve all players requiring a new drink, don’t forget to check for id\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Is this the real life, is this just fantasy, until the next bomb, you are freddie mercury, you must sing everything you say\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Your highness, the queen (you) has just arrived, re enter the party and make sure there is fanfare\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Now stick em up, the player to your left has got you in a stick up, they keep a gun pointed at you and you need to keep at least a hand in the air until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Put me on the floor, put your card on the floor, do not move the card once it’s on the floor, one body part must be in contact with the card at all times until the next bomb\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : I think your fly is undone, get someone to look without being called out on this card\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : Slip me into someone’s pocket without them noticing, no bad touch\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Of course i can fit my whole fist in my mouth, demonstrate or take a punishment\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Wear all of your clothes inside out, use a bathroom if you are shy, underwear is at personal discretion\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Welcome to my crib, give everyone a tour of the house, if people get bored you get punished\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : What’s that outside, convince someone to leave the room without getting called on this card\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Secret santa, get someone to tell you what they want for christmas without being called on this card\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - I’m just a magnetic person, only it’s one that repels, no one is allowed within arms reach of you until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Get hype, get a video of everyone in the room hitting that dab\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I never knew that, find out something new about 3 people, no punishments for this, it’s wholesome\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Wagon wheel, everyone do a cartwheel or forward roll\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - The irony, no more using the letter “E”, get it ironE\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Walk a mile in someone's shoes, trade shoes with someone, if you don’t have shoes then take someone else’s, you don't need to walk a mile it's just a saying\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : Find a penny, pick it up, get it into someones drink and save the queen\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Hobbit, you are now the shortest person in the room, only walk on your knees\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Gameshow host, ask everyone a trivia question, anyone who gets theirs wrong gets a punishment\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Heads I win, tails you lose, make a bet with the entire room and flip a coin, losers follow through\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Grave robbing, you pick a card from what’s already been played, everything is funnier the second time\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : You sly dog, convince someone it was actually their turn to draw, if they do play the next card, if not you get punished\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Freaky friday, swap identities with someone at the party, both of you will be punished everytime one of you fucks up, do this until the room decides otherwise\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Fuck you, ideas are hard, you get a punishment\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret :You mission should you choose to accept it is to give this card to another player, this message will self destruct in 30 seconds\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Cultural, anyone without foreign currency on them drinks\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - High school crush, you may not speak to anyone of the opposite sex directly, you must either pass notes or ask someone to relay the message for you\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I’m not scared of heights, be piggybacked by another player until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Gimp, the player to your right is your dom, nothing too naughty\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Vampire, if you manage to touch another players neck they get a punishment\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Irish handcuffs, any players currently holding their drink must  grab a second glass and hold both at all times\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : Is this word spelled write, convince another player to look at this card, if they do they get punished\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - David and goliath, tallest and shortest players drink\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - The human carpet, hairiest player drinks\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Whose line is it anyway, perform an improvised scene with two other players and audience suggestions,  if no one laughs you lose\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - your mother, first person without a to mama joke loses\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - your father, first person without a dad joke loses, audience judge dadliness of joke\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Awkward date, make an excuse to leave your current group, if you get called out you lose\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Pick up artist, get 3 phone numbers by the end of the night, doesn't matter who or how\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - It's raining inside, find something to hold over your head until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Just need somebody to lean on, you must always be leaning on a wall or another player until the next bomb\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - I'm just really embarrassed about my weenus, if anyone touches your elbows until the next bomb you drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Weird science, the skin on the elbow has no nerve endings, prove this is true by kicking someone else's without them noticing\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Hands on your knees, all players must have a hand on another players knee, with permission of course\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : Wink murder, wink at everyone in the room without being called out on it\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Body shots, everyone must do a body shot from the person who draws this card\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : I got an ouchie, convince someone in the room to kiss it better, points for style\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Spy hunter, leave the room, everyone elect the spy, figure out who it is before it's too late, the spy needs to have a card visible on them\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - TSA, everyone leave and reenter the room, drawer is a security guard checking for problems, no naughty pat downs\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I'm batman, speak like batman, might end up being the bane of your existence\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The fates will guide me, choose a player to be your DM, roll a dice before any decision, your successful ness is based on its score and what the DM determines, don’t lose the dice\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Cinephile, describe the plot of a film really badly, if anyone can guess it in under a minute you both win, if more than one person can you lose\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - MAD, there is a  nuke inbound, get everyone into the shelter, the bathroom. Thanks rocket man\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Oh yes we can can, get everyone to link arms and do the cancan\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Judas, recreate da vinci's last supper with everyone in the room and get a photo\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Godfather, act like a mobster until the next bomb or sleep with the fishes\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : This is such a nice material, convince everyone in the room to touch an item of your clothing\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Prison bitch, find someone with a pocket, turn it inside out and hold it until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Bureaucracy at its finest, you need all of your actions , excluding paperwork, to be written in paper work and signed by 2 other people in the room\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Grenade, shout grenade and get down on the floor, last man gets punished\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : Cheapskate, drink from another players glass without them noticing\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Earthquake, get under a door frame or table until the end of the song\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - One word story, go around the room and create a story, if it's shit everyone get punished\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - We love short shorts, roll up any clothing until it's above the knees\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Oh jeeves, select a butler, you may no longer touch your own drink only them. Remember to be polite\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Dobby is free, give another player one of your socks\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Group theory, say a number and get into groups of that size, anyone not in a group drinks, if perfect groups are made punish this player\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : The circle of life, just start singing the opening to the lion king until at least 3 other people join in, punishments to anyone that doesn’t join\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Pictionary, spend 1 minute drawing something, if no one guesses it or more than one person guess it you lose, guessers answer at the same time\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Bridge over troubled water, select an opponent; plank until someone loses, if it takes to long make them less stable\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Trex mode, they have tiny arms and so now do you, keep those elbows tucked into your side until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I’m just really cold, put on an item of clothing from each player in the room, get nice and toasty\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I will be your wingman any day, get someone to kiss the person to your left, a peck on the cheek is fine\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Draw me like one of your french girls, partner up and do a life sketch, ps:There was enough space\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Gaze into the future, guess the next song on the playlist or you lose\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Mystic meg, give someone in the room a palm or tarot reading, if they think it's shit you lose\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - I was paying attention, say the name of everyone at the party, you lose if you can't but it happens to the best of us\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Merry Christmas,sing a christmas carol with everyone, then drink because that's how I get through Christmas every year\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Not always danger, convince someone your middle name is Blank, literally the word Blank, by any means necessary\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : Plagiarism, convince someone that you actually came up with this card,if not you get a punishment\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Hide and seek, one minute to hide and one minute to find, no leaving the property and no locking doors\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Aww Cute, give this card to someone who makes you smile, then share a friendly drink\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -High to low, only you may speak, you have 1 minute to get everyone into height order\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Respect your elders, only you may speak, you have until the end of the song to get everyone from youngest to oldest\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Oral gymnastics, say a tongue twister, anyone who can't repeat it loses\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Rock bottom, give this card to someone with a great arse, drink with them to celebrate their achievement\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Creepy pasta, set the atmosphere and tell a ghost story, if its resoundingly badyou looooooose\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I just love to party, pick up 2 more cards to play, you have to complete them back to back, I’m nice though because you have 2 songs to do it in\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : Do I know you, get someone's name wrong 3 times without being called out\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Watch yo profanity, call out all instances of swearing in the most annoying way possible, you may hand out drinks to those breaking rules, but snitches get stitches so join them in drinking\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The Donald, you are now the current, when written, POTUS , the man, the myth, the orangutan.  Try not to blow your own trumpet\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - That's pretty backwards, put all of your clothes on backwards, you will probably look like the kid from the exorcist\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - This is democracy manifest, select the Lord commander by vote, whenever they drink so does everyone else, organise this vote in any way you see fit\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Not the drink you're looking for, convince two people they accidentally swapped drinks, get them to drink each others or you lose\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret : High fives, high five everyone in the room, but catch one person out with a low five too slow manoeuvre, pure evil\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Fiesta, get the room to do a Mexican wave, then everyone drinks, it is a party after all\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Just Incredible, all sentences you say must now contain an Owen Wilsonism, Wow\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Announce loudly that you have just shit yourself, anyone who doesn't applaud drinks\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Press up challenge, select an opponent, most press ups wins\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Boat race, split into 2 teams, finish your drink then tap the next person to start theirs, first team to have their last man finish wins\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Cops and Robbers, the person to your left is under arrest, hold their hand to stop them escaping until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Arms of steel, choose an opponent and arm wrestle them, loser gets a punishment\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Deathbed, you have just died, everyone in the room hold your funeral, remember to drink at the wake\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Snake oil, pick something to sell to the room, if no one wants to buy you will be punished\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The tortoise and the hare, select someone else to be the hare, you need to perform everything extremely slowly , they need to everything at double speed, including speaking\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Mirror image, copy all actions of the person to your right until the next bomb\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Lap dance, give someone in the room a lapdance\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The human canvas, let everyone give you a temporary tattoo\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Auld langs aye, everyone link arms and sing Auld Langs Aye like it was new years all over again\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \" Easy - Paparazzi, you are now famous, anytime someone takes a photo of you take a drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Pablo Escobar, grab an empty glass, extort some drink from everyone in the room, this is now your drink until you finish it, remember the accent\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Body guard, select a VIP,  you must protect this person and be with them at all times, anyone wanting an audience with them needs to be checked over first\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The clique, get into groups, everyone needs physical contact with at least one other group member at all times, no outsiders\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Greed, take a sip from 5 other players drinks\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Sloth, remain seated or lie down at all times\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Gluttony, your glass must always be full, if you drink anything you need to top up\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Wrath, select 3 others, whenever you drink so do they\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Pride, stand up and start flexing, keep a straight face, if you laugh you lose\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Envy, take the drink from another player, this is now yours they can go get another, they can choose to down it instead of handing it over\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Lust, give a kiss to every player in the room, location and duration at your own discretion\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I get the reference, only speak in quotes, you can be challenged on these\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Charades, two teams, play a game of charades, losing team gets a punishment\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Of course i can tap dance, demonstrate this, if you suck take a drink\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret; get someone to fall for the classic what’s up dog trick\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Hands in the middle, last person to leave wins\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - It’s your birthday, get everyone in the room to sing happy birthday to you, then drink to celebrate\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Not as Popey as I’d hopey, bless everyone with water by flicking some of it on them like holy water\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - When I say jump, up to 3 times you can ask everyone in the room to stop everything and jump\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Edward something hands, pick up two objects, these are your hands until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Play a game of ninja with everyone at the party, the google if you don’t know it\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Play a game of simon says until there is a winner, you are simon\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Shuffle the deck, everyone change seats, no just moving a few over, get nice and swapped\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Rock paper scissors tournament, if you lose a game you are knocked out, play until there is an ultimate victor\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -The human knot, everyone stand in circles of roughly 10 in an open space, everyone grab hands with 2 other people not next to you in the circle, without letting go untangle yourselves, if 2 groups get competitive\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Human sculptures, pick 3 other people, as the party for a sculpture suggestion, work together with to create that suggestion\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - The vikings have landed, whenever you make a horn noise everyone must start rowing, last 2 to join in drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Wiggle Wiggle, show everyone that you can do the worm\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Business meeting, get everyone outside, greet everyone with a firm handshake as they come back in, anyone who smiles or laughs loses\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Identity complex, before speaking everyone must shout their name until the next bomb\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Don’t look at Me, if any player looks at you you can tell them to drink until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Who laughs last laughs most, whenever someone laughs everyone must join in, last one to join in loses\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Thumb Master, this one's a classic, when you put a thumb on a flat surface, last person to do so loses\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Photographer, grab a camera, when you want to take a photo count down from 3, then shoot, anyone not in the photo drinks\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Give me love, every time you drink choose someone to give you a compliment, if they repeat one already said they drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Face off, no one is allowed to touch their own face until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Two hands to be safe, you may only drink if both hands are on your glass until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I feel so close to you, whenever someone says another players name they must put a hand on that players face until the next offence of this rule\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The King, all other players heads must be below yours at all times until the next bomb, offenders drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The Gecko, you may say gecko up to 3 times, all players must have 3 limbs against a wall until told otherwise\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Moaners, you may only moan other players names until the next bomb, offenders drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Indiana Jones, choose one person to be a boulder, if this person ever makes physical contact with you drink\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - That’s so rude, no pointing until the next bomb, offenders drink\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Limited vocabulary, you may only speak in single syllable words until the next bomb\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Secret service, you may only speak if you hold two fingers up to your ear until the next bomb, calls must be finished with over or out\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret: Naughty, call out something a player says as an innuendo, do this 3 times without being caught\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Ever so polite, anytime a player drinks they must thank the person responsible for said drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - 3 Minute Epic, pick 2 other players, choose a film and act it out in its entirety before the time is up\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Pairs, everyone get into pairs, you must now do whatever your partner does, anyone single can drown their sorrows by finishing their drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Police raid, everyone get hands against the wall, stay here until told otherwise\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - High society, speak eloquently and refined until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Mr Robot, stand up and perform the robot for everyone to see\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret: Just checking, ask at least 5 people if they are having a fun time without being caught\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Speaks their mind, say whatever you are about to do before you do it until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Chuckle brothers, pick another player and an object, you both need to carry this between you until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Eco Warrior, collect any used drinks containers and carry them with you until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - For the hangover, down a pint of water, you can thank me later\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Medusa, if you can make eye contact with someone they have to drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The quest for the holy grail, find a suitable and empty vessel, fill it up and have everyone drink the aqua vitae\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Split or steal, choose another player, you each have the choice to split or steal, write this down and reveal at the same time, if you both split drink, if only one splits they get a minor punishment, if you both steal you both get a major punishment\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Battle of the bands, suggest a song to play next, if people hate it drink, but the songs goes on anyway\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret: That old move, yawn and put your arm around the person to your left or right without being called out on it\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Flamingo, stand on one leg until the end of the next song, whenever you stumble take a drink and get back on one leg\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Straight face, if you laugh or smile until the next bomb take a drink and try again\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Censorship, ban a word for the rest of the evening, offenders will drink\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Of course i can lick my elbow, keep trying until you succeed or someone licks it for you\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret: Yes man, agree with everything said to you and nod very enthusiastically until the next bomb, if you aren’t called out you can make everyone drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - 20 questions, pick something, everyone in the room gets to ask a question to determine what it is, if they get it you lose, no cheating\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Poison tester, check 5 other people drinks to make sure there isn’t anything wrong with them\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Political race, choose an opponent, stand at opposite ends of the room and give a short campaign speech, everyone gets up and stand with the candidate they support, losing side drinks\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Film critic, name an actor and first person who can’t name a film they have been in drinks\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Catwalk, choose a team of stylists, 3 mins to dress you up then strut your stuff for everyone to see, anyone not cheering can drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret: Health trend, convince someone that you have just started a fake health trend, if they call you out you lose\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - No boundaries, you may only speak to people by whispering in their ear\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Wedding speech, the two people to your left just tied the knot, give a best man’s speech to the room\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Homewrecker, go sit/stand between two other people and make them make space for you\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Porn name, you make only be referred to by your porn name for the next 2 bombs\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Gap yahh, select a partner, both of you want to tell everyone about how life changing your gap year was, accent included\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Drill sergeant, any questions you ask must be followed up by the whole room shouting sir yes sir, sir no sir, or hurrah else they drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The mineshaft, select a group of 4 others, you must leave the room until you all have finished your drinks\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Guys I'm really sorry, apologies to the room for your transgressions\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Caught a big one, get 4 others mime reeling you in the take a photo of them holding you up like the catch of the day\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Just married, carry another player into the room as everyone celebrates your nuptials\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - My feet hurt, give your shoes to another player for then to hold until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - I just prepared is all, find something to use as a life vest and hold onto it until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Jon Snow, until the next bomb you may not bend either of your knees\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Cheers, everyone clink glasses and take a drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Dating profile, stand up and present to the room why you are such a catch, 80s video dating style\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret : Man spread, you must take up as much space as possible, ignore all protests of this until the next bomb\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Two truths and a lie, tell 2 truths and one lie to the room, then ask them to guess which is the lie, everyone who gets it wrong drinks, you drink for every person who got it correct\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Tag, play tag for a minute, whoever ends up as it gets to drink 5 times, you start as it, no tag backs\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Train conductor, you need to mime pulling a whistle and make a choo choo noise before you drink until the next bomb\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Zero sum game, give out as many drinks as you are willing to do yourself, you can measure out volumes if you really want\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Zombie, if you can touch a player they must take 5 drinks and become infected, they can now infect other players, play until all players are infected\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Revolver, you may point a finger gun at any player and shoot them, they must drink twice, up to six shots, have fun partner\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Wood worm, chairs are banned until the next bomb, all players must stand or be sat on the floor\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Group hug, what more do you want me to say\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Hello operator, if you want to speak to someone you must mime a phone and wait for them to pick up before you can speak, this also works in reverse, you may make a ringing noise\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret: Cupid, blow a kiss to three people without being called out on it\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The hula hoop, pretend to have a hula hoop until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Air orchestra, choose 3 other players to join your quartet, you must play air instruments to all songs until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The mad scientist, take 2 people drinks and mix them with each other, acting as though you are performing an experiment, they must continue to use them for the rest of the game\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Godzilla, recreate Godzilla destroying tokyo for the group to see, include roaring\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Chariots of Fire, all players leave the room and re enter to Vangelis (from chariots of fire) in slow motion, pretending to run along the beach\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Chariots of Rome, choose 4 other players to leave the room with you, re enter as a chariot and do a lap of the room to thunderous applause\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Music video, choose a song and take 3 mins to plan a music video before shooting it with the group\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Eye spy, play a game of eye spy with everyone in the room, they have one minute to guess, losers drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Long distance, you must stay as far away as possible from the player to your left, still try to make it work though\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Got your back, everyone get a partner and get back to back, thighs parallel to the floor, last group standing wins, any loners can play with the wall\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -The thing from the deep, choose 2 other players, get back to back and link arms, stay like this until the next bomb, hope none of you need to pee\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Who is it, stand up and close your eyes, one player selected by the group will grab your shoulders, if you can guess who it is you win\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - True russian, select an opponent, winner is the person who can slav squat for longer, both heels must be on the floor\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Conga line, everyone leave the room and re enter as a conga line, you may lead, appropriate music encouraged\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Hoist the sails, you are the pirate captain, if you shout out to hoist the sails the last person to mime pulling a rope and respond aye aye captain drinks, up to three times\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Sudden inspection, call the group to stand up at attention and inspect everyones drink, if they are looking low they need to finish it and get another one, try not to be too harsh\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Bugs Bunny, you must start all answers to questions with what’s up doc or drink, pesky rabbit\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret: High five or low five everyone in the room, anyone who refuses can drunk once you have finished going around\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Andy’s home, if anyone yells andy’s home the room needs to freeze like in toy story until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Rally the troops, stand tall and give a rousing speech to the room to prepare them for the sesh ahead\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Get down to the boogie, choose an opponent's and have a dance off, winner is determined by the most applause\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - No one puts baby in the corner, put someone in the corner facing the wall for 3 minutes\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Approval, get 5 other players to pat you on the head and tell you that you did well, mmmmhm attention\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Groovy baby, act like Austin Powers until the next bomb\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Melody so sweet, whistle a song, if no one can guess it you drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret: google it, get someone to google a dubious fact you tell them, if you can you can make them drink, if not you can\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Robin hood, choose 3 people with near full glasses and 3 with near empty, those with empty must take 3 drinks from those with more wealth than they\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Seize the means of production, everyone drink until everyone has the same amount of drink left in their hands\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Spin the barrel, starting with you every other person stand up and move round clockwise 3 spaces\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Imperialism, put a tea bag in your drink and leave it there or finish the drink, rule britannia\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Reach for the sky, last person to touch the ceiling loses\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \" Medium - Country road, stick that bad boy on, everyone loves that song\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Let's put a smile on that face, act like the joker until the next bomb, if asked how you got these scars tell a different story each time\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Sock puppets, wear your socks on your hands until the next bomb, you may only communicate through the sock puppets, borrow someone else's socks if needed\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -I really like that outfit, choose another player to swap clothes with, you may only keep your underwear\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Best dressed award, the room votes on who is dressed the best, they can give a short acceptance speech and take a drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Zoo keeper, give 3 other players animals to imitate until the next bomb, any gorillas must be called Harambe\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -Secret: Drama queen, shout out that you refuse to do that and storm out of the room, anyone who comes to get you is a kind soul, everyone else can drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Reaction time, hold a coin in a face up palm until the next bomb, if someone can take the coin before you can close your hand around it you drink, no forcing your hand open or the can finish theirs\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Secret: Fly on the wall, there is a flying insect that you are trying to swat, if you can mime for a minute without being called out you win\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Witch hunt, once before the next bomb you may point at a player a accuse them of being a witch, the room will then chant witch until they finish their drink\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Master debater, select an opponent, as the room for a topic and decide who is on what side, you each have a minute to make a case, the room decides who the winner is\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Elephant in the room, anytime another player mentions anything to do with you they must drink\"}\n" +
            "{\"difficulty\" : \"Easy\" , \"rule\" : \"Easy - Hail Caesar, if a player is able to mime stabbing you in the back you must drink, et tu Brute?\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - Oh Romeo, deliver a poem of love to a player of your choosing in front of the group\"}\n" +
            "{\"difficulty\" : \"Medium\" , \"rule\" : \"Medium - The player who reads this card is now considered the Bard, rhyme they must, from dawn until dusk, waiting for the bomb will be hard\"}\n" +
            "{\"difficulty\" : \"Hard\" , \"rule\" : \"Hard -If you don't refer to someone by name give them a kiss on the cheek, to say sorry\"}\n" ;
}

