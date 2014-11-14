package com.example.textrecoapp.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.example.textrecoapp.App;
import com.example.textrecoapp.gameplay.Artifact;
import com.example.textrecoapp.models.StoryStep;
import com.example.textrecoapp.models.StoryMission;

public class StoryGenerator {

	private Map<String, List<StoryMission>> stories;

	public StoryGenerator() {
		init();
	}

	private void init() {
		stories = new HashMap<String, List<StoryMission>>();
		List<Artifact> artifacts = App.getInstance().getCartographer()
				.getArtifacts();
		Random random = new Random();

		List<StoryMission> storiesForKomita = new ArrayList<StoryMission>();
		List<StoryStep> list1 = new ArrayList<StoryStep>();
		Artifact a = artifacts.get(random.nextInt(16));
		list1.add(new StoryStep(a, "description 1 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(16));
		list1.add(new StoryStep(a, "description 2 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(16));
		list1.add(new StoryStep(a, "description 3 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(16));
		list1.add(new StoryStep(a, "description 4 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(16));
		list1.add(new StoryStep(a, "description 5 <br> " + a.getName()));
		StoryMission sm1 = new StoryMission(1, "Story 1", "Introduction to story 1", list1);
		storiesForKomita.add(sm1);
		List<StoryStep> list2 = new ArrayList<StoryStep>();
		a = artifacts.get(random.nextInt(16));
		list2.add(new StoryStep(a, "description 1 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(16));
		list2.add(new StoryStep(a, "description 2 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(16));
		list2.add(new StoryStep(a, "description 3 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(16));
		list2.add(new StoryStep(a, "description 4 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(16));
		list2.add(new StoryStep(a, "description 5 <br> " + a.getName()));
		StoryMission sm2 = new StoryMission(2, "Story 2", "Introduction to story 2", list2);
		storiesForKomita.add(sm2);
		stories.put("Komita", storiesForKomita);

		List<StoryMission> storiesForPartizan = new ArrayList<StoryMission>();
		List<StoryStep> list3 = new ArrayList<StoryStep>();
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list3.add(new StoryStep(a, "description 1 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list3.add(new StoryStep(a, "description 2 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list3.add(new StoryStep(a, "description 3 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list3.add(new StoryStep(a, "description 4 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list3.add(new StoryStep(a, "description 5 <br> " + a.getName()));
		StoryMission sm3 = new StoryMission(3, "Story 3", "Introduction to story 3", list3);
		storiesForPartizan.add(sm3);
		List<StoryStep> list4 = new ArrayList<StoryStep>();
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list4.add(new StoryStep(a, "description 1 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list4.add(new StoryStep(a, "description 2 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list4.add(new StoryStep(a, "description 3 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list4.add(new StoryStep(a, "description 4 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(32 - 17) + 16);
		list4.add(new StoryStep(a, "description 5 <br> " + a.getName()));
		StoryMission sm4 = new StoryMission(4, "Story 4", "Introduction to story 4", list4);
		storiesForPartizan.add(sm4);
		stories.put("Partizan", storiesForPartizan);

		List<StoryMission> storiesForWarrior = new ArrayList<StoryMission>();
		List<StoryStep> list5 = new ArrayList<StoryStep>();
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list5.add(new StoryStep(a, "description 1 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list5.add(new StoryStep(a, "description 2 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list5.add(new StoryStep(a, "description 3 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list5.add(new StoryStep(a, "description 4 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list5.add(new StoryStep(a, "description 5 <br> " + a.getName()));
		StoryMission sm5 = new StoryMission(5, "Story 5", "Introduction to story 5", list5);
		storiesForWarrior.add(sm5);
		List<StoryStep> list6 = new ArrayList<StoryStep>();
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list6.add(new StoryStep(a, "description 1 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list6.add(new StoryStep(a, "description 2 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list6.add(new StoryStep(a, "description 3 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list6.add(new StoryStep(a, "description 4 <br> " + a.getName()));
		a = artifacts.get(random.nextInt(48 - 33) + 32);
		list6.add(new StoryStep(a, "description 5 <br> " + a.getName()));
		StoryMission sm6 = new StoryMission(6, "Story 6", "Introduction to story 6", list6);
		storiesForWarrior.add(sm6);
		stories.put("Ancient warrior", storiesForWarrior);
	}

	public Map<String, List<StoryMission>> getStories() {
		return stories;
	}
}
