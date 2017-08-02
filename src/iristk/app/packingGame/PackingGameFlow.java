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
			// Line: 21
			try {
				EXECUTION: {
					int count = getCount(1811075214) + 1;
					incrCount(1811075214);
					// Line: 22
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 22, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 24
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 24, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 25
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 22, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 21, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 29
			try {
				count = getCount(2121744517) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(2121744517);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 29, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 31
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 31, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 29, 36));
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
			// Line: 36
			try {
				EXECUTION: {
					int count = getCount(476402209) + 1;
					incrCount(476402209);
					// Line: 37
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
								if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 37, 12)))) {
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
								if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 37, 12)))) {
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
								if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 37, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 42
					ExplainGame state14 = new ExplainGame();
					flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 42, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 36, 12));
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
			// Line: 47
			try {
				EXECUTION: {
					int count = getCount(1143839598) + 1;
					incrCount(1143839598);
					iristk.situated.SystemAgentFlow.say state15 = agent.new say();
					StringCreator string16 = new StringCreator();
					string16.append("The game goes like this:");
					state15.setText(string16.toString());
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 47, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state17 = agent.new say();
					StringCreator string18 = new StringCreator();
					string18.append("I will start by saying I pack my bag and I take with me for example");
					// Line: 47
					string18.append(packables.getRandom().getValue());
					string18.append(". You then have to repeat the exact same sentence. At the end, you add another item to the 			packing list and it is my turn again. We continue this until one of us either fails to recall the exact 			sequence of the items or all items have been packed. Do you understand the rules?");
					state17.setText(string18.toString());
					if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 47, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state19 = agent.new listen();
					if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 47, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 47, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 55
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
							if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 55, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 57
							PackIntro state22 = new PackIntro();
							flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 57, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 55, 59));
			}
			// Line: 59
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
							if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 59, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 61
							Idle state25 = new Idle();
							flowThread.gotoState(state25, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 61, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 59, 57));
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
			// Line: 67
			try {
				EXECUTION: {
					int count = getCount(425918570) + 1;
					incrCount(425918570);
					iristk.situated.SystemAgentFlow.say state26 = agent.new say();
					StringCreator string27 = new StringCreator();
					string27.append("I pack my bag and I take with me:");
					state26.setText(string27.toString());
					if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 67, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 69
					PackRandomItem state28 = new PackRandomItem();
					if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 34)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 70
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
								if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 70, 12)))) {
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
								if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 70, 12)))) {
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
								if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 70, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 75
					PlayerPacks state38 = new PlayerPacks();
					flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 75, 33)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 67, 12));
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
			// Line: 81
			try {
				EXECUTION: {
					int count = getCount(1973538135) + 1;
					incrCount(1973538135);
					// Line: 82
					if (!packingList.contains(newItem)) {
						// Line: 83
						packingList.add(newItem);
						// Line: 84
						System.out.println(packingList);
						// Line: 85
					} else if (packingList.contains(newItem)) {
						iristk.situated.SystemAgentFlow.say state39 = agent.new say();
						StringCreator string40 = new StringCreator();
						// Line: 85
						string40.append(newItem);
						string40.append("is already in the packing list");
						state39.setText(string40.toString());
						if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 82, 46)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 87
						CheckAgain state41 = new CheckAgain();
						flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 87, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 89
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 89, 12)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 81, 13));
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
			// Line: 121
			try {
				EXECUTION: {
					int count = getCount(1579572132) + 1;
					incrCount(1579572132);
					iristk.situated.SystemAgentFlow.listen state42 = agent.new listen();
					if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 121, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 121, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 125
			try {
				count = getCount(359023572) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:packables")) {
						incrCount(359023572);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 126
							String response = asString(asString(event.get("text")).toLowerCase());
							// Line: 128
							Scanner sc = new Scanner(response);
							while(sc.hasNext()) {
								String nextWord = sc.next().toLowerCase();
								if (packables.containsKey(nextWord)) {
									responseList.add(nextWord);
								}
							};
							// Line: 138
							Iterator responseIterator = (Iterator) responseList.iterator();
							// Line: 140
							{
								RepeatHandler handler43 = new RepeatHandler();
								while (packingListIterator.hasNext()) {
									// Line: 141
									String nextResponse = asString(responseIterator.next());
									// Line: 142
									if (!packingListIterator.next().equals(nextResponse) && packingListIterator.hasNext()) {
										iristk.situated.SystemAgentFlow.say state44 = agent.new say();
										StringCreator string45 = new StringCreator();
										// Line: 142
										string45.append(nextResponse);
										string45.append("is not in the packing list");
										state44.setText(string45.toString());
										if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 142, 107)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
										// Line: 144
										CheckAgain state46 = new CheckAgain();
										flowThread.gotoState(state46, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 144, 32)));
										eventResult = EVENT_ABORTED;
										break EXECUTION;
									}
									handler43.next();
								}
							}
							// Line: 148
							if (responseIterator.hasNext()) {
								// Line: 149
								UserAddsItem state47 = new UserAddsItem();
								state47.setNewItem(responseIterator.next());
								if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 149, 69)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 150
							} else if (!responseIterator.hasNext()) {
								iristk.situated.SystemAgentFlow.say state48 = agent.new say();
								StringCreator string49 = new StringCreator();
								string49.append("Seems like you forgot to add a new item to the list");
								state48.setText(string49.toString());
								if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 148, 42)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 152
								CheckAgain state50 = new CheckAgain();
								flowThread.gotoState(state50, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 152, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 155
							FurhatPacks state51 = new FurhatPacks();
							flowThread.gotoState(state51, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 155, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 125, 64));
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
			// Line: 162
			try {
				EXECUTION: {
					int count = getCount(1101288798) + 1;
					incrCount(1101288798);
					// Line: 163
					boolean chosen52 = false;
					boolean matching53 = true;
					while (!chosen52 && matching53) {
						int rand54 = random(942731712, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching53 = false;
						if (true) {
							matching53 = true;
							if (rand54 >= 0 && rand54 < 1) {
								chosen52 = true;
								iristk.situated.SystemAgentFlow.say state55 = agent.new say();
								StringCreator string56 = new StringCreator();
								string56.append("OK it's my turn now");
								state55.setText(string56.toString());
								if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 163, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching53 = true;
							if (rand54 >= 1 && rand54 < 2) {
								chosen52 = true;
								iristk.situated.SystemAgentFlow.say state57 = agent.new say();
								StringCreator string58 = new StringCreator();
								string58.append("Alright then. My turn");
								state57.setText(string58.toString());
								if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 163, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching53 = true;
							if (rand54 >= 2 && rand54 < 3) {
								chosen52 = true;
								iristk.situated.SystemAgentFlow.say state59 = agent.new say();
								StringCreator string60 = new StringCreator();
								string60.append("Good job. Now me");
								state59.setText(string60.toString());
								if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 163, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					iristk.situated.SystemAgentFlow.say state61 = agent.new say();
					StringCreator string62 = new StringCreator();
					string62.append("I pack my bag and I take with me");
					// Line: 163
					{
						RepeatHandler handler63 = new RepeatHandler();
						while (packingListIterator.hasNext()) {
							// Line: 163
							string62.append(packables.get(packingListIterator.next()));
							handler63.next();
						}
					}
					string62.append("and");
					state61.setText(string62.toString());
					if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 162, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 176
					PackRandomItem state64 = new PackRandomItem();
					if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 176, 34)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 177
					PlayerPacks state65 = new PlayerPacks();
					flowThread.gotoState(state65, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 177, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 162, 12));
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
			// Line: 187
			try {
				EXECUTION: {
					int count = getCount(2104457164) + 1;
					incrCount(2104457164);
					// Line: 188
					{
						RepeatHandler handler66 = new RepeatHandler();
						while (packingList.contains(randomPackable.getValue())) {
							// Line: 189
							randomPackable = packables.getRandom();
							handler66.next();
						}
					}
					// Line: 191
					packingList.add(randomPackable.getKey());
					iristk.situated.SystemAgentFlow.say state67 = agent.new say();
					StringCreator string68 = new StringCreator();
					// Line: 191
					string68.append(randomPackable.getValue());
					state67.setText(string68.toString());
					if (!flowThread.callState(state67, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 187, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 195
					System.out.println("Packing list contains: " + packingList);
					// Line: 196
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 196, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 187, 12));
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
			// Line: 201
			try {
				EXECUTION: {
					int count = getCount(1192108080) + 1;
					incrCount(1192108080);
					// Line: 202
					packingList.clear();
					// Line: 203
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 203, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 201, 12));
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
			// Line: 209
			try {
				EXECUTION: {
					int count = getCount(380894366) + 1;
					incrCount(380894366);
					iristk.situated.SystemAgentFlow.say state69 = agent.new say();
					StringCreator string70 = new StringCreator();
					string70.append("Do you want to play again?");
					state69.setText(string70.toString());
					if (!flowThread.callState(state69, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 209, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state71 = agent.new listen();
					if (!flowThread.callState(state71, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 209, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 209, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 213
			try {
				count = getCount(237852351) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(237852351);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state72 = agent.new say();
							StringCreator string73 = new StringCreator();
							string73.append("Okay, let's play again.");
							state72.setText(string73.toString());
							if (!flowThread.callState(state72, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 213, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 215
							ClearPackingList state74 = new ClearPackingList();
							if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 215, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 216
							PackIntro state75 = new PackIntro();
							flowThread.gotoState(state75, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 216, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 213, 58));
			}
			// Line: 218
			try {
				count = getCount(1608446010) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1608446010);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state76 = agent.new say();
							StringCreator string77 = new StringCreator();
							string77.append("Okay, goodbye");
							state76.setText(string77.toString());
							if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 218, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 220
							ClearPackingList state78 = new ClearPackingList();
							if (!flowThread.callState(state78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 220, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 221
							Idle state79 = new Idle();
							flowThread.gotoState(state79, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 221, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 218, 57));
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
			// Line: 226
			try {
				count = getCount(1705929636) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1705929636);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state80 = agent.new gesture();
							state80.setName("smile");
							if (!flowThread.callState(state80, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 226, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 226, 102));
			}
			// Line: 229
			try {
				count = getCount(1221555852) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:stop")) {
						incrCount(1221555852);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state81 = agent.new say();
							StringCreator string82 = new StringCreator();
							string82.append("Goodbye");
							state81.setText(string82.toString());
							if (!flowThread.callState(state81, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 229, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 233
							ClearPackingList state83 = new ClearPackingList();
							if (!flowThread.callState(state83, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 233, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 234
							Idle state84 = new Idle();
							flowThread.gotoState(state84, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 234, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 229, 59));
			}
			// Line: 236
			try {
				count = getCount(1252585652) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1252585652);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state85 = agent.new say();
						StringCreator string86 = new StringCreator();
						string86.append("Sorry, I didn't get that.");
						state85.setText(string86.toString());
						if (!flowThread.callState(state85, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 236, 36)))) {
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
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 236, 36));
			}
			// Line: 240
			try {
				count = getCount(1785210046) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1785210046);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state87 = agent.new attendOther();
						state87.setMode("eyes");
						if (!flowThread.callState(state87, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 240, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state88 = agent.new say();
						StringCreator string89 = new StringCreator();
						string89.append("I didn't ask you.");
						state88.setText(string89.toString());
						if (!flowThread.callState(state88, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 240, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state90 = agent.new attendOther();
						state90.setMode("eyes");
						if (!flowThread.callState(state90, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 240, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 244
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 244, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 240, 41));
			}
			// Line: 246
			try {
				count = getCount(1361960727) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1361960727);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state91 = agent.new say();
						StringCreator string92 = new StringCreator();
						string92.append("Don't speak at the same time.");
						state91.setText(string92.toString());
						if (!flowThread.callState(state91, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 246, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 248
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 248, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 246, 42));
			}
			// Line: 250
			try {
				count = getCount(125130493) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(125130493);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state93 = agent.new say();
						StringCreator string94 = new StringCreator();
						string94.append("Sorry, I didn't hear anything.");
						state93.setText(string94.toString());
						if (!flowThread.callState(state93, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 250, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 252
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 252, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 250, 38));
			}
			// Line: 254
			try {
				count = getCount(166239592) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(166239592);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 255
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state95 = agent.new attendRandom();
								if (!flowThread.callState(state95, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 255, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 257
							} else {
								// Line: 258
								Idle state96 = new Idle();
								flowThread.gotoState(state96, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 258, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 254, 69));
			}
			// Line: 261
			try {
				count = getCount(2085857771) + 1;
				if (event.triggers("repeat")) {
					incrCount(2085857771);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 262
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 262, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 261, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
