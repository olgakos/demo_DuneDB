import models.QuoteData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.Specs.request;
import static specs.Specs.responseSpec;


public class PoetryAPITests {


    @Test
    @DisplayName("Проверка наличия списка пользователей")
    public void usersListTest() {

        step("Отправляем запрос о списке пользователей");
        QuoteData data = given()
                .spec(request) //base URL
                .when()
                .get("/author") //+запрос
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(QuoteData.class);

        step("Проверяем совпадение данных пользователей в ответе");
        //assertEquals(129, data.getAuthor()[0]);
        //assertEquals(129, data.getAuthor()[0].getId());
    }


    // №2
    //https://poetrydb.org/title/Ozymandias
    @Test
    @DisplayName("002")
    void updateUserTest2() {
        String data = "{\"title\": \"Ozymandias\"}";
        given()
                .body(data)
                .contentType(JSON)
                .when()
                .put("https://poetrydb.org/")//put
                .then()
                .body("title", is("Ozymandias"))
                .body("author", is("Percy Bysshe Shelley"));
                //.body("job", is("zion resident1"));
    }

    // №2
    //https://poetrydb.org/author/Ernest Dowson/author,title,linecount
    @Test
    @DisplayName("003")
    void test3() {
        String data = "{\"title\": \"Ozymandias\"}";
        given()
                .body(data)
                .contentType(JSON)
                .when()
                .put("https://poetrydb.org/")//put
                .then()
                .body("title", is("Ozymandias"))
                .body("author", is("Percy Bysshe Shelley"));
        //.body("job", is("zion resident1"));
    }
    


    // №1
    @Test
    @DisplayName("00001")
    void registerNewUserTest200() {
        /*
        ВХОДНЫЕ ДАННЫЕ:
        request: https://poetrydb.org/

        data:
        {
        "author": "Ernest Dowson",
        //"title":  "The Moon Maiden's Song"
        }
        response:

       {
  "authors": [
    "Adam Lindsay Gordon",
    "Alan Seeger",
    "Alexander Pope",
    "Algernon Charles Swinburne",
    "Ambrose Bierce",
    "Amy Levy",
    "Andrew Marvell",
    "Ann Taylor",
    "Anne Bradstreet",
    "Anne Bronte",
    "Anne Killigrew",
    "Anne Kingsmill Finch",
    "Annie Louisa Walker",
    "Arthur Hugh Clough",
    "Ben Jonson",
    "Charles Kingsley",
    "Charles Sorley",
    "Charlotte Bronte",
    "Charlotte Smith",
    "Christina Rossetti",
    "Christopher Marlowe",
    "Christopher Smart",
    "Coventry Patmore",
    "Edgar Allan Poe",
    "Edmund Spenser",
    "Edward Fitzgerald",
    "Edward Lear",
    "Edward Taylor",
    "Edward Thomas",
    "Eliza Cook",
    "Elizabeth Barrett Browning",
    "Emily Bronte",
    "Emily Dickinson",
    "Emma Lazarus",
    "Ernest Dowson",
    "Eugene Field",
    "Francis Thompson",
    "Geoffrey Chaucer",
    "George Eliot",
    "George Gordon, Lord Byron",
    "George Herbert",
    "George Meredith",
    "Gerard Manley Hopkins",
    "Helen Hunt Jackson",
    "Henry David Thoreau",
    "Henry Vaughan",
    "Henry Wadsworth Longfellow",
    "Hugh Henry Brackenridge",
    "Isaac Watts",
    "James Henry Leigh Hunt",
    "James Thomson",
    "James Whitcomb Riley",
    "Jane Austen",
    "Jane Taylor",
    "John Clare",
    "John Donne",
    "John Dryden",
    "John Greenleaf Whittier",
    "John Keats",
    "John McCrae",
    "John Milton",
    "John Trumbull",
    "John Wilmot",
    "Jonathan Swift",
    "Joseph Warton",
    "Joyce Kilmer",
    "Julia Ward Howe",
    "Jupiter Hammon",
    "Katherine Philips",
    "Lady Mary Chudleigh",
    "Lewis Carroll",
    "Lord Alfred Tennyson",
    "Louisa May Alcott",
    "Major Henry Livingston, Jr.",
    "Mark Twain",
    "Mary Elizabeth Coleridge",
    "Matthew Arnold",
    "Matthew Prior",
    "Michael Drayton",
    "Oliver Goldsmith",
    "Oliver Wendell Holmes",
    "Oscar Wilde",
    "Paul Laurence Dunbar",
    "Percy Bysshe Shelley",
    "Philip Freneau",
    "Phillis Wheatley",
    "Ralph Waldo Emerson",
    "Richard Crashaw",
    "Richard Lovelace",
    "Robert Browning",
    "Robert Burns",
    "Robert Herrick",
    "Robert Louis Stevenson",
    "Robert Southey",
    "Robinson",
    "Rupert Brooke",
    "Samuel Coleridge",
    "Samuel Johnson",
    "Sarah Flower Adams",
    "Sidney Lanier",
    "Sir John Suckling",
    "Sir Philip Sidney",
    "Sir Thomas Wyatt",
    "Sir Walter Raleigh",
    "Sir Walter Scott",
    "Stephen Crane",
    "Thomas Campbell",
    "Thomas Chatterton",
    "Thomas Flatman",
    "Thomas Gray",
    "Thomas Hood",
    "Thomas Moore",
    "Thomas Warton",
    "Walt Whitman",
    "Walter Savage Landor",
    "Wilfred Owen",
    "William Allingham",
    "William Barnes",
    "William Blake",
    "William Browne",
    "William Cowper",
    "William Cullen Bryant",
    "William Ernest Henley",
    "William Lisle Bowles",
    "William Morris",
    "William Shakespeare",
    "William Topaz McGonagall",
    "William Vaughn Moody",
    "William Wordsworth"
  ]
}

         */

        String registerData = "{\"author\": \"\"}";

        given()
                .body(registerData)
                .contentType(JSON)
                .when()
                .post("https://poetrydb.org/")
                .then()
                .body("authors", is("[\n" +
                        "    \"Adam Lindsay Gordon\",\n" +
                        "    \"Alan Seeger\",\n" +
                        "    \"Alexander Pope\",\n" +
                        "    \"Algernon Charles Swinburne\",\n" +
                        "    \"Ambrose Bierce\",\n" +
                        "    \"Amy Levy\",\n" +
                        "    \"Andrew Marvell\",\n" +
                        "    \"Ann Taylor\",\n" +
                        "    \"Anne Bradstreet\",\n" +
                        "    \"Anne Bronte\",\n" +
                        "    \"Anne Killigrew\",\n" +
                        "    \"Anne Kingsmill Finch\",\n" +
                        "    \"Annie Louisa Walker\",\n" +
                        "    \"Arthur Hugh Clough\",\n" +
                        "    \"Ben Jonson\",\n" +
                        "    \"Charles Kingsley\",\n" +
                        "    \"Charles Sorley\",\n" +
                        "    \"Charlotte Bronte\",\n" +
                        "    \"Charlotte Smith\",\n" +
                        "    \"Christina Rossetti\",\n" +
                        "    \"Christopher Marlowe\",\n" +
                        "    \"Christopher Smart\",\n" +
                        "    \"Coventry Patmore\",\n" +
                        "    \"Edgar Allan Poe\",\n" +
                        "    \"Edmund Spenser\",\n" +
                        "    \"Edward Fitzgerald\",\n" +
                        "    \"Edward Lear\",\n" +
                        "    \"Edward Taylor\",\n" +
                        "    \"Edward Thomas\",\n" +
                        "    \"Eliza Cook\",\n" +
                        "    \"Elizabeth Barrett Browning\",\n" +
                        "    \"Emily Bronte\",\n" +
                        "    \"Emily Dickinson\",\n" +
                        "    \"Emma Lazarus\",\n" +
                        "    \"Ernest Dowson\",\n" +
                        "    \"Eugene Field\",\n" +
                        "    \"Francis Thompson\",\n" +
                        "    \"Geoffrey Chaucer\",\n" +
                        "    \"George Eliot\",\n" +
                        "    \"George Gordon, Lord Byron\",\n" +
                        "    \"George Herbert\",\n" +
                        "    \"George Meredith\",\n" +
                        "    \"Gerard Manley Hopkins\",\n" +
                        "    \"Helen Hunt Jackson\",\n" +
                        "    \"Henry David Thoreau\",\n" +
                        "    \"Henry Vaughan\",\n" +
                        "    \"Henry Wadsworth Longfellow\",\n" +
                        "    \"Hugh Henry Brackenridge\",\n" +
                        "    \"Isaac Watts\",\n" +
                        "    \"James Henry Leigh Hunt\",\n" +
                        "    \"James Thomson\",\n" +
                        "    \"James Whitcomb Riley\",\n" +
                        "    \"Jane Austen\",\n" +
                        "    \"Jane Taylor\",\n" +
                        "    \"John Clare\",\n" +
                        "    \"John Donne\",\n" +
                        "    \"John Dryden\",\n" +
                        "    \"John Greenleaf Whittier\",\n" +
                        "    \"John Keats\",\n" +
                        "    \"John McCrae\",\n" +
                        "    \"John Milton\",\n" +
                        "    \"John Trumbull\",\n" +
                        "    \"John Wilmot\",\n" +
                        "    \"Jonathan Swift\",\n" +
                        "    \"Joseph Warton\",\n" +
                        "    \"Joyce Kilmer\",\n" +
                        "    \"Julia Ward Howe\",\n" +
                        "    \"Jupiter Hammon\",\n" +
                        "    \"Katherine Philips\",\n" +
                        "    \"Lady Mary Chudleigh\",\n" +
                        "    \"Lewis Carroll\",\n" +
                        "    \"Lord Alfred Tennyson\",\n" +
                        "    \"Louisa May Alcott\",\n" +
                        "    \"Major Henry Livingston, Jr.\",\n" +
                        "    \"Mark Twain\",\n" +
                        "    \"Mary Elizabeth Coleridge\",\n" +
                        "    \"Matthew Arnold\",\n" +
                        "    \"Matthew Prior\",\n" +
                        "    \"Michael Drayton\",\n" +
                        "    \"Oliver Goldsmith\",\n" +
                        "    \"Oliver Wendell Holmes\",\n" +
                        "    \"Oscar Wilde\",\n" +
                        "    \"Paul Laurence Dunbar\",\n" +
                        "    \"Percy Bysshe Shelley\",\n" +
                        "    \"Philip Freneau\",\n" +
                        "    \"Phillis Wheatley\",\n" +
                        "    \"Ralph Waldo Emerson\",\n" +
                        "    \"Richard Crashaw\",\n" +
                        "    \"Richard Lovelace\",\n" +
                        "    \"Robert Browning\",\n" +
                        "    \"Robert Burns\",\n" +
                        "    \"Robert Herrick\",\n" +
                        "    \"Robert Louis Stevenson\",\n" +
                        "    \"Robert Southey\",\n" +
                        "    \"Robinson\",\n" +
                        "    \"Rupert Brooke\",\n" +
                        "    \"Samuel Coleridge\",\n" +
                        "    \"Samuel Johnson\",\n" +
                        "    \"Sarah Flower Adams\",\n" +
                        "    \"Sidney Lanier\",\n" +
                        "    \"Sir John Suckling\",\n" +
                        "    \"Sir Philip Sidney\",\n" +
                        "    \"Sir Thomas Wyatt\",\n" +
                        "    \"Sir Walter Raleigh\",\n" +
                        "    \"Sir Walter Scott\",\n" +
                        "    \"Stephen Crane\",\n" +
                        "    \"Thomas Campbell\",\n" +
                        "    \"Thomas Chatterton\",\n" +
                        "    \"Thomas Flatman\",\n" +
                        "    \"Thomas Gray\",\n" +
                        "    \"Thomas Hood\",\n" +
                        "    \"Thomas Moore\",\n" +
                        "    \"Thomas Warton\",\n" +
                        "    \"Walt Whitman\",\n" +
                        "    \"Walter Savage Landor\",\n" +
                        "    \"Wilfred Owen\",\n" +
                        "    \"William Allingham\",\n" +
                        "    \"William Barnes\",\n" +
                        "    \"William Blake\",\n" +
                        "    \"William Browne\",\n" +
                        "    \"William Cowper\",\n" +
                        "    \"William Cullen Bryant\",\n" +
                        "    \"William Ernest Henley\",\n" +
                        "    \"William Lisle Bowles\",\n" +
                        "    \"William Morris\",\n" +
                        "    \"William Shakespeare\",\n" +
                        "    \"William Topaz McGonagall\",\n" +
                        "    \"William Vaughn Moody\",\n" +
                        "    \"William Wordsworth\"\n" +
                        "  ]"));
    }

    //------------------------------------------
    // №2
    @Test
    @DisplayName("Обновить пользователя")
    void updateUserTest() {
        String data = "{\"name\": \"morpheus2\", \"job\": \"zion resident1\"}";
        given()
                .body(data)
                .contentType(JSON)
                .when()
                .put("https://reqres.in/api/users")//put
                .then()
                .body("name", is("morpheus2"))
                .body("job", is("zion resident1"));
    }

}
