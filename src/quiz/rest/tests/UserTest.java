package quiz.rest.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import net.ko.framework.Ko;
import net.ko.framework.KoSession;
import net.ko.kobject.KListObject;

import org.junit.BeforeClass;
import org.junit.Test;

import qcm.models.KGroupe;
import qcm.models.KUtilisateur;
import qcm.utils.HttpUtils;
import qcm.utils.MyGsonBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserTest {
	private static Gson gson;
	private static String baseUrl;

	@BeforeClass
	public static void setUp() {
		gson = MyGsonBuilder.create();
		baseUrl = "http://127.0.0.1:8080/Q2Base_rest/rest/";
		Ko.kstart();
	}

	@Test
	public void testGetGroupes() {
		try {
			KUtilisateur user = KoSession.kloadOne(KUtilisateur.class);
			KListObject<KGroupe> groupesFromDb=user.getGroupes();
			String jsonGroupes = HttpUtils.getHTML(baseUrl + "user/"+user.getId()+"/all/groupes");
			Type listType = new TypeToken<List<KGroupe>>() {
			}.getType();
			List<KGroupe> groupes = gson.fromJson(jsonGroupes, listType);
			int cpt=0;
			assertEquals(groupes.size(), groupesFromDb.count());
			for(KGroupe gr : groupesFromDb) {
				if(groupes.contains(gr))
					cpt++;
			}
			assertEquals(cpt, groupes.size());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetQuiz() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRealisations() {
		fail("Not yet implemented");
	}

	@Test
	public void testConnect() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetValuesToKObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadOneIntInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadOneInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		try {
			KListObject<KUtilisateur> usersFromDb = KoSession.kloadMany(KUtilisateur.class);
			String jsonUsers = HttpUtils.getHTML(baseUrl + "user/all");
			Type listType = new TypeToken<List<KUtilisateur>>() {
			}.getType();
			List<KUtilisateur> users = gson.fromJson(jsonUsers, listType);
			assertEquals(users.size(), usersFromDb.count());
//			JsonParser parser = new JsonParser();
//			JsonArray jArray = parser.parse(jsonUsers).getAsJsonArray();
//			ArrayList<KUtilisateur> users = new ArrayList<KUtilisateur>();
//			for(JsonElement obj : jArray) {
//				KUtilisateur user = gson.fromJson(obj, listType);
//				users.add(user);
//			}
			for (int i = 0; i < users.size(); i++) {
				assertEquals((users.get(i)).getLogin(), usersFromDb.get(i).getLogin());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetOneIntInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOneInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMemberIntStringInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMemberIntString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListMemberIntStringInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListMemberIntString() {
		fail("Not yet implemented");
	}

}
