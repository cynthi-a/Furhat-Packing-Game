package iristk.app.packingGame;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;
import java.util.List;
import java.util.LinkedList;
import javafx.util.Pair;
import java.util.Iterator;
import java.util.Scanner;

public class PackingGameFlow extends iristk.flow.Flow {

	private iristk.situated.SystemAgentFlow agent;
	private PackablesMap packables;
	private iristk.situated.SystemAgent system;
	private LinkedList<String> packingList;

	private void initVariables() {
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
		packingList = (LinkedList<String>) new java.util.LinkedList<String>();
	}

	public iristk.situated.SystemAgent getSystem() {
		return this.system;
	}

	public void setSystem(iristk.situated.SystemAgent value) {
		this.system = value;
	}

	public LinkedList<String> getPackingList() {
		return this.packingList;
	}

	public void setPackingList(LinkedList<String> value) {
		this.packingList = value;
	}

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	public PackablesMap getPackables() {
		return this.packables;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("system")) return this.system;
		if (name.equals("packingList")) return this.packingList;
		if (name.equals("agent")) return this.agent;
		if (name.equals("packables")) return this.packables;
		return null;
	}


	public PackingGameFlow(iristk.situated.SystemAgentFlow agent, PackablesMap packables) {
		this.agent = agent;
		this.packables = packables;
		initVariables();
	}

	@Override
	public State getInitialState() {return new PackIntro();}


	private class Idle extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 20
			try {
				EXECUTION: {
					int count = getCount(1811075214) + 1;
					incrCount(1811075214);
					// Line: 21
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 21, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 23
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 23, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 24
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 21, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 20, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 28
			try {
				count = getCount(2121744517) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(2121744517);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 28, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 30
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 30, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 28, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Greeting extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 35
			try {
				EXECUTION: {
					int count = getCount(476402209) + 1;
					incrCount(476402209);
					// Line: 36
					boolean chosen5 = false;
					boolean matching6 = true;
					while (!chosen5 && matching6) {
						int rand7 = random(1490180672, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching6 = false;
						if (true) {
							matching6 = true;
							if (rand7 >= 0 && rand7 < 1) {
								chosen5 = true;
								iristk.situated.SystemAgentFlow.say state8 = agent.new say();
								StringCreator string9 = new StringCreator();
								string9.append("Greetings! Do you want to play with me?");
								state8.setText(string9.toString());
								state8.setGesture("smile");
								if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 36, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching6 = true;
							if (rand7 >= 1 && rand7 < 2) {
								chosen5 = true;
								iristk.situated.SystemAgentFlow.say state10 = agent.new say();
								StringCreator string11 = new StringCreator();
								string11.append("Hi. I am Furhat! Let's play a game.");
								state10.setText(string11.toString());
								state10.setGesture("smile");
								if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 36, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching6 = true;
							if (rand7 >= 2 && rand7 < 3) {
								chosen5 = true;
								iristk.situated.SystemAgentFlow.say state12 = agent.new say();
								StringCreator string13 = new StringCreator();
								string13.append("Hey there! Let's play a game.");
								state12.setText(string13.toString());
								state12.setGesture("smile");
								if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 36, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 41
					ExplainGame state14 = new ExplainGame();
					flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 41, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 35, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class ExplainGame extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 46
			try {
				EXECUTION: {
					int count = getCount(1143839598) + 1;
					incrCount(1143839598);
					iristk.situated.SystemAgentFlow.say state15 = agent.new say();
					StringCreator string16 = new StringCreator();
					string16.append("The game goes like this:");
					state15.setText(string16.toString());
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 46, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state17 = agent.new say();
					StringCreator string18 = new StringCreator();
					string18.append("I will start by saying I pack my bag and I take with me for example");
					// Line: 46
					string18.append(packables.getRandom().getValue());
					string18.append(". You then have to repeat the exact same sentence. At the end, you add another item to the 			packing list and it is my turn again. We continue this until one of us either fails to recall the exact 			sequence of the items or all items have been packed. Do you understand the rules?");
					state17.setText(string18.toString());
					if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 46, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state19 = agent.new listen();
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 46, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 46, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 54
			try {
				count = getCount(250075633) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(250075633);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state20 = agent.new say();
							StringCreator string21 = new StringCreator();
							string21.append("Okay, let's play");
							state20.setText(string21.toString());
							if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 54, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 56
							PackIntro state22 = new PackIntro();
							flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 56, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 54, 59));
			}
			// Line: 58
			try {
				count = getCount(517938326) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(517938326);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state23 = agent.new say();
							StringCreator string24 = new StringCreator();
							string24.append("Okay, let Cynthia explain it again.");
							state23.setText(string24.toString());
							if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 58, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 60
							Idle state25 = new Idle();
							flowThread.gotoState(state25, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 60, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 58, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	public class PackIntro extends Dialog implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 66
			try {
				EXECUTION: {
					int count = getCount(425918570) + 1;
					incrCount(425918570);
					iristk.situated.SystemAgentFlow.say state26 = agent.new say();
					StringCreator string27 = new StringCreator();
					string27.append("I pack my bag and I take with me:");
					state26.setText(string27.toString());
					if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 66, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 68
					PackRandomItem state28 = new PackRandomItem();
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 68, 34)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 69
					boolean chosen29 = false;
					boolean matching30 = true;
					while (!chosen29 && matching30) {
						int rand31 = random(204349222, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching30 = false;
						if (true) {
							matching30 = true;
							if (rand31 >= 0 && rand31 < 1) {
								chosen29 = true;
								iristk.situated.SystemAgentFlow.say state32 = agent.new say();
								StringCreator string33 = new StringCreator();
								string33.append("Your turn");
								state32.setText(string33.toString());
								if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching30 = true;
							if (rand31 >= 1 && rand31 < 2) {
								chosen29 = true;
								iristk.situated.SystemAgentFlow.say state34 = agent.new say();
								StringCreator string35 = new StringCreator();
								string35.append("Now you");
								state34.setText(string35.toString());
								if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching30 = true;
							if (rand31 >= 2 && rand31 < 3) {
								chosen29 = true;
								iristk.situated.SystemAgentFlow.say state36 = agent.new say();
								StringCreator string37 = new StringCreator();
								string37.append("It's your turn");
								state36.setText(string37.toString());
								if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 74
					PlayerPacks state38 = new PlayerPacks();
					flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 74, 33)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 66, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class UserAddsItem extends Dialog {

		final State currentState = this;
		public String newItem = null;

		public void setNewItem(Object value) {
			if (value != null) {
				newItem = asString(value);
				params.put("newItem", value);
			}
		}


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 80
			try {
				EXECUTION: {
					int count = getCount(1973538135) + 1;
					incrCount(1973538135);
					// Line: 81
					if (!packingList.contains(newItem)) {
						// Line: 82
						packingList.add(newItem);
						// Line: 83
						System.out.println(packingList);
						// Line: 84
					} else if (packingList.contains(newItem)) {
						iristk.situated.SystemAgentFlow.say state39 = agent.new say();
						StringCreator string40 = new StringCreator();
						// Line: 84
						string40.append(newItem);
						string40.append("is already in the packing list");
						state39.setText(string40.toString());
						if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 81, 46)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 86
						CheckAgain state41 = new CheckAgain();
						flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 86, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 88
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 88, 12)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 80, 13));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PlayerPacks extends Dialog {

		final State currentState = this;

		public Iterator packingListIterator = (Iterator) packingList.iterator();
		public List responseList = asList(new LinkedList<String>());

		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 95
			try {
				EXECUTION: {
					int count = getCount(1579572132) + 1;
					incrCount(1579572132);
					iristk.situated.SystemAgentFlow.listen state42 = agent.new listen();
					if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 95, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 95, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 99
			try {
				count = getCount(359023572) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:packables")) {
						incrCount(359023572);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 100
							String response = asString(asString(event.get("text")).toLowerCase());
							// Line: 102
							Scanner sc = new Scanner(response);
							while(sc.hasNext()) {
								String nextWord = sc.next();
								if (packables.containsKey(nextWord)) {
									responseList.add(nextWord);
								}
							};
							// Line: 112
							Iterator responseIterator = (Iterator) responseList.iterator();
							// Line: 114
							{
								RepeatHandler handler43 = new RepeatHandler();
								while (packingListIterator.hasNext()) {
									// Line: 115
									String nextResponse = asString(responseIterator.next());
									// Line: 116
									if (!packingListIterator.next().equals(nextResponse) && packingListIterator.hasNext()) {
										// Line: 118
										if (packingList.contains(nextResponse)) {
											iristk.situated.SystemAgentFlow.say state44 = agent.new say();
											StringCreator string45 = new StringCreator();
											// Line: 118
											string45.append(nextResponse);
											string45.append("is in the packing list but at a different position");
											state44.setText(string45.toString());
											if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 118, 53)))) {
												eventResult = EVENT_ABORTED;
												break EXECUTION;
											}
											// Line: 120
										} else if (!packingList.contains(nextResponse)) {
											iristk.situated.SystemAgentFlow.say state46 = agent.new say();
											StringCreator string47 = new StringCreator();
											// Line: 120
											string47.append(nextResponse);
											string47.append("is not in the packing list");
											state46.setText(string47.toString());
											if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 118, 53)))) {
												eventResult = EVENT_ABORTED;
												break EXECUTION;
											}
										}
										// Line: 123
										CheckAgain state48 = new CheckAgain();
										flowThread.gotoState(state48, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 123, 32)));
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									handler43.next();
								}
							}
							// Line: 127
							if (responseIterator.hasNext()) {
								// Line: 128
								UserAddsItem state49 = new UserAddsItem();
								state49.setNewItem(responseIterator.next());
								if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 128, 69)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 129
							} else if (!responseIterator.hasNext()) {
								iristk.situated.SystemAgentFlow.say state50 = agent.new say();
								StringCreator string51 = new StringCreator();
								string51.append("Seems like you forgot to add a new item to the list");
								state50.setText(string51.toString());
								if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 127, 42)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 131
								CheckAgain state52 = new CheckAgain();
								flowThread.gotoState(state52, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 131, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 134
							FurhatPacks state53 = new FurhatPacks();
							flowThread.gotoState(state53, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 134, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 99, 64));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class FurhatPacks extends Dialog {

		final State currentState = this;

		public Iterator packingListIterator = (Iterator) packingList.iterator();

		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 141
			try {
				EXECUTION: {
					int count = getCount(971848845) + 1;
					incrCount(971848845);
					// Line: 142
					boolean chosen54 = false;
					boolean matching55 = true;
					while (!chosen54 && matching55) {
						int rand56 = random(1910163204, 4, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching55 = false;
						if (true) {
							matching55 = true;
							if (rand56 >= 0 && rand56 < 1) {
								chosen54 = true;
								iristk.situated.SystemAgentFlow.say state57 = agent.new say();
								StringCreator string58 = new StringCreator();
								string58.append("OK it's my turn now");
								state57.setText(string58.toString());
								if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 142, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching55 = true;
							if (rand56 >= 1 && rand56 < 2) {
								chosen54 = true;
								iristk.situated.SystemAgentFlow.say state59 = agent.new say();
								StringCreator string60 = new StringCreator();
								string60.append("Alright then. My turn");
								state59.setText(string60.toString());
								if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 142, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching55 = true;
							if (rand56 >= 2 && rand56 < 3) {
								chosen54 = true;
								iristk.situated.SystemAgentFlow.say state61 = agent.new say();
								StringCreator string62 = new StringCreator();
								string62.append("Good job. Now me");
								state61.setText(string62.toString());
								if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 142, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching55 = true;
							if (rand56 >= 3 && rand56 < 4) {
								chosen54 = true;
								iristk.situated.SystemAgentFlow.say state63 = agent.new say();
								StringCreator string64 = new StringCreator();
								string64.append("Well done. I will go on");
								state63.setText(string64.toString());
								if (!flowThread.callState(state63, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 142, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					iristk.situated.SystemAgentFlow.say state65 = agent.new say();
					StringCreator string66 = new StringCreator();
					string66.append("I pack my bag and I take with me");
					// Line: 142
					{
						RepeatHandler handler67 = new RepeatHandler();
						while (packingListIterator.hasNext()) {
							// Line: 142
							string66.append(packables.get(packingListIterator.next()));
							handler67.next();
						}
					}
					string66.append("and");
					state65.setText(string66.toString());
					if (!flowThread.callState(state65, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 141, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 156
					PackRandomItem state68 = new PackRandomItem();
					if (!flowThread.callState(state68, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 156, 34)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 157
					PlayerPacks state69 = new PlayerPacks();
					flowThread.gotoState(state69, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 157, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 141, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class PackRandomItem extends State {

		final State currentState = this;

		public Pair<String,String> randomPackable = (Pair<String,String>) packables.getRandom();

		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 164
			try {
				EXECUTION: {
					int count = getCount(1940030785) + 1;
					incrCount(1940030785);
					// Line: 165
					{
						RepeatHandler handler70 = new RepeatHandler();
						while (packingList.contains(randomPackable.getValue())) {
							// Line: 166
							randomPackable = packables.getRandom();
							handler70.next();
						}
					}
					// Line: 168
					packingList.add(randomPackable.getKey());
					iristk.situated.SystemAgentFlow.say state71 = agent.new say();
					StringCreator string72 = new StringCreator();
					// Line: 168
					string72.append(randomPackable.getValue());
					state71.setText(string72.toString());
					if (!flowThread.callState(state71, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 164, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 172
					System.out.println("Packing list: " + packingList);
					// Line: 173
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 173, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 164, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class ClearPackingList extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 178
			try {
				EXECUTION: {
					int count = getCount(864237698) + 1;
					incrCount(864237698);
					// Line: 179
					packingList.clear();
					// Line: 180
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 180, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 178, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 186
			try {
				EXECUTION: {
					int count = getCount(608188624) + 1;
					incrCount(608188624);
					// Line: 187
					boolean chosen73 = false;
					boolean matching74 = true;
					while (!chosen73 && matching74) {
						int rand75 = random(1451270520, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching74 = false;
						if (true) {
							matching74 = true;
							if (rand75 >= 0 && rand75 < 1) {
								chosen73 = true;
								iristk.situated.SystemAgentFlow.say state76 = agent.new say();
								StringCreator string77 = new StringCreator();
								string77.append("This round, we managed to remember");
								// Line: 187
								string77.append(packingList.size());
								string77.append("items");
								state76.setText(string77.toString());
								if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 187, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching74 = true;
							if (rand75 >= 1 && rand75 < 2) {
								chosen73 = true;
								iristk.situated.SystemAgentFlow.say state78 = agent.new say();
								StringCreator string79 = new StringCreator();
								string79.append("We remembered");
								// Line: 187
								string79.append(packingList.size());
								string79.append("items in this round");
								state78.setText(string79.toString());
								if (!flowThread.callState(state78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 187, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching74 = true;
							if (rand75 >= 2 && rand75 < 3) {
								chosen73 = true;
								iristk.situated.SystemAgentFlow.say state80 = agent.new say();
								StringCreator string81 = new StringCreator();
								string81.append("Let's see if we can beat");
								// Line: 187
								string81.append(packingList.size());
								string81.append("items in the next round");
								state80.setText(string81.toString());
								if (!flowThread.callState(state80, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 187, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 192
					boolean chosen82 = false;
					boolean matching83 = true;
					while (!chosen82 && matching83) {
						int rand84 = random(1608446010, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching83 = false;
						if (true) {
							matching83 = true;
							if (rand84 >= 0 && rand84 < 1) {
								chosen82 = true;
								iristk.situated.SystemAgentFlow.say state85 = agent.new say();
								StringCreator string86 = new StringCreator();
								string86.append("Do you want to play again?");
								state85.setText(string86.toString());
								if (!flowThread.callState(state85, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 192, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching83 = true;
							if (rand84 >= 1 && rand84 < 2) {
								chosen82 = true;
								iristk.situated.SystemAgentFlow.say state87 = agent.new say();
								StringCreator string88 = new StringCreator();
								string88.append("Would you like another round?");
								state87.setText(string88.toString());
								if (!flowThread.callState(state87, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 192, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching83 = true;
							if (rand84 >= 2 && rand84 < 3) {
								chosen82 = true;
								iristk.situated.SystemAgentFlow.say state89 = agent.new say();
								StringCreator string90 = new StringCreator();
								string90.append("Shall we try again?");
								state89.setText(string90.toString());
								if (!flowThread.callState(state89, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 192, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					iristk.situated.SystemAgentFlow.listen state91 = agent.new listen();
					if (!flowThread.callState(state91, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 186, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 186, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 199
			try {
				count = getCount(992136656) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(992136656);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state92 = agent.new say();
							StringCreator string93 = new StringCreator();
							string93.append("Okay, let's play again.");
							state92.setText(string93.toString());
							if (!flowThread.callState(state92, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 199, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 201
							ClearPackingList state94 = new ClearPackingList();
							if (!flowThread.callState(state94, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 201, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 202
							PackIntro state95 = new PackIntro();
							flowThread.gotoState(state95, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 202, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 199, 58));
			}
			// Line: 204
			try {
				count = getCount(1705929636) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1705929636);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state96 = agent.new say();
							StringCreator string97 = new StringCreator();
							string97.append("Okay, goodbye");
							state96.setText(string97.toString());
							if (!flowThread.callState(state96, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 204, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 206
							ClearPackingList state98 = new ClearPackingList();
							if (!flowThread.callState(state98, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 206, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 207
							Idle state99 = new Idle();
							flowThread.gotoState(state99, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 207, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 204, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 212
			try {
				count = getCount(1252585652) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1252585652);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state100 = agent.new gesture();
							state100.setName("smile");
							if (!flowThread.callState(state100, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 212, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 212, 102));
			}
			// Line: 215
			try {
				count = getCount(2036368507) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:stop")) {
						incrCount(2036368507);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state101 = agent.new say();
							StringCreator string102 = new StringCreator();
							string102.append("Goodbye");
							state101.setText(string102.toString());
							if (!flowThread.callState(state101, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 215, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 219
							ClearPackingList state103 = new ClearPackingList();
							if (!flowThread.callState(state103, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 219, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 220
							Idle state104 = new Idle();
							flowThread.gotoState(state104, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 220, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 215, 59));
			}
			// Line: 222
			try {
				count = getCount(1361960727) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1361960727);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state105 = agent.new say();
						StringCreator string106 = new StringCreator();
						string106.append("Sorry, I didn't get that.");
						state105.setText(string106.toString());
						if (!flowThread.callState(state105, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 222, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 224
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 224, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 222, 36));
			}
			// Line: 226
			try {
				count = getCount(125130493) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(125130493);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state107 = agent.new attendOther();
						state107.setMode("eyes");
						if (!flowThread.callState(state107, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 226, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state108 = agent.new say();
						StringCreator string109 = new StringCreator();
						string109.append("I didn't ask you.");
						state108.setText(string109.toString());
						if (!flowThread.callState(state108, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 226, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state110 = agent.new attendOther();
						state110.setMode("eyes");
						if (!flowThread.callState(state110, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 226, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 230
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 230, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 226, 41));
			}
			// Line: 232
			try {
				count = getCount(166239592) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(166239592);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state111 = agent.new say();
						StringCreator string112 = new StringCreator();
						string112.append("Don't speak at the same time.");
						state111.setText(string112.toString());
						if (!flowThread.callState(state111, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 232, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 234
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 234, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 232, 42));
			}
			// Line: 236
			try {
				count = getCount(385242642) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(385242642);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state113 = agent.new say();
						StringCreator string114 = new StringCreator();
						string114.append("Sorry, I didn't hear anything.");
						state113.setText(string114.toString());
						if (!flowThread.callState(state113, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 236, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 238
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 238, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 236, 38));
			}
			// Line: 240
			try {
				count = getCount(2085857771) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(2085857771);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 241
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state115 = agent.new attendRandom();
								if (!flowThread.callState(state115, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 241, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 243
							} else {
								// Line: 244
								Idle state116 = new Idle();
								flowThread.gotoState(state116, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 244, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 240, 69));
			}
			// Line: 247
			try {
				count = getCount(285377351) + 1;
				if (event.triggers("repeat")) {
					incrCount(285377351);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 248
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 248, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 247, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
