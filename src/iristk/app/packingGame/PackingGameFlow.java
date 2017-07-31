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
			// Line: 23
			try {
				EXECUTION: {
					int count = getCount(1607460018) + 1;
					incrCount(1607460018);
					// Line: 24
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 24, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 26
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 26, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 27
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 24, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 23, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 31
			try {
				count = getCount(245565335) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(245565335);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 31, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 33
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 33, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 31, 36));
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
			// Line: 38
			try {
				EXECUTION: {
					int count = getCount(183264084) + 1;
					incrCount(183264084);
					// Line: 39
					boolean chosen5 = false;
					boolean matching6 = true;
					while (!chosen5 && matching6) {
						int rand7 = random(476402209, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
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
								if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 39, 12)))) {
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
								if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 39, 12)))) {
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
								if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 39, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 44
					ExplainGame state14 = new ExplainGame();
					flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 44, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 38, 12));
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
			// Line: 50
			try {
				EXECUTION: {
					int count = getCount(1919892312) + 1;
					incrCount(1919892312);
					iristk.situated.SystemAgentFlow.say state15 = agent.new say();
					StringCreator string16 = new StringCreator();
					string16.append("I am going on holidays. I need to pack some stuff. Do you want to help?");
					state15.setText(string16.toString());
					if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 50, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 52
					PackIntro state17 = new PackIntro();
					flowThread.gotoState(state17, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 52, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 50, 12));
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
					int count = getCount(358699161) + 1;
					incrCount(358699161);
					iristk.situated.SystemAgentFlow.say state18 = agent.new say();
					StringCreator string19 = new StringCreator();
					string19.append("I pack my bag and I take with me:");
					state18.setText(string19.toString());
					if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 66, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 68
					PackRandomItem state20 = new PackRandomItem();
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 68, 34)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 69
					boolean chosen21 = false;
					boolean matching22 = true;
					while (!chosen21 && matching22) {
						int rand23 = random(914424520, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching22 = false;
						if (true) {
							matching22 = true;
							if (rand23 >= 0 && rand23 < 1) {
								chosen21 = true;
								iristk.situated.SystemAgentFlow.say state24 = agent.new say();
								StringCreator string25 = new StringCreator();
								string25.append("Your turn");
								state24.setText(string25.toString());
								if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching22 = true;
							if (rand23 >= 1 && rand23 < 2) {
								chosen21 = true;
								iristk.situated.SystemAgentFlow.say state26 = agent.new say();
								StringCreator string27 = new StringCreator();
								string27.append("Now you");
								state26.setText(string27.toString());
								if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching22 = true;
							if (rand23 >= 2 && rand23 < 3) {
								chosen21 = true;
								iristk.situated.SystemAgentFlow.say state28 = agent.new say();
								StringCreator string29 = new StringCreator();
								string29.append("It's your turn");
								state28.setText(string29.toString());
								if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 69, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					// Line: 74
					PlayerPacks state30 = new PlayerPacks();
					flowThread.gotoState(state30, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 74, 33)));
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
					int count = getCount(204349222) + 1;
					incrCount(204349222);
					// Line: 85
					if (!packingList.contains(newItem)) {
						// Line: 86
						System.out.println(newItem +" added");
						// Line: 87
						packingList.add(newItem);
						// Line: 88
						System.out.println(packingList);
						// Line: 90
					} else if (packingList.contains(newItem)) {
						iristk.situated.SystemAgentFlow.say state31 = agent.new say();
						StringCreator string32 = new StringCreator();
						// Line: 90
						string32.append(newItem);
						string32.append("is already in the packing list");
						state31.setText(string32.toString());
						if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 85, 46)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 92
						CheckAgain state33 = new CheckAgain();
						flowThread.gotoState(state33, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 92, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 95
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 95, 12)));
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

		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 103
			try {
				EXECUTION: {
					int count = getCount(1365202186) + 1;
					incrCount(1365202186);
					iristk.situated.SystemAgentFlow.listen state34 = agent.new listen();
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 103, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 103, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 107
			try {
				count = getCount(1651191114) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:packables")) {
						incrCount(1651191114);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 108
							String response = asString(asString(event.get("sem:packables")).toLowerCase());
							// Line: 109
							String firstInList = asString(packingListIterator.next());
							// Line: 111
							System.out.println("response"+response);System.out.println("firstInList: "+firstInList);
							// Line: 113
							if (!(firstInList.equals(response)) && packingListIterator.hasNext()) {
								// Line: 114
								System.out.println(response+" is not in the packing list");
								iristk.situated.SystemAgentFlow.say state35 = agent.new say();
								StringCreator string36 = new StringCreator();
								// Line: 114
								string36.append(response);
								string36.append("is not in the packing list");
								state35.setText(string36.toString());
								if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 113, 88)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 116
								CheckAgain state37 = new CheckAgain();
								flowThread.gotoState(state37, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 116, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 118
							} else if ((firstInList.equals(response)) && packingListIterator.hasNext()) {
								// Line: 119
								flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 119, 16)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 121
							} else {
								// Line: 122
								UserAddsItem state38 = new UserAddsItem();
								state38.setNewItem(response);
								if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 122, 55)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
							// Line: 126
							FurhatPacks state39 = new FurhatPacks();
							flowThread.gotoState(state39, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 126, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 107, 64));
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
		public int count = asInteger(0);

		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 133
			try {
				EXECUTION: {
					int count = getCount(1404928347) + 1;
					incrCount(1404928347);
					// Line: 134
					boolean chosen40 = false;
					boolean matching41 = true;
					while (!chosen40 && matching41) {
						int rand42 = random(604107971, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
						matching41 = false;
						if (true) {
							matching41 = true;
							if (rand42 >= 0 && rand42 < 1) {
								chosen40 = true;
								iristk.situated.SystemAgentFlow.say state43 = agent.new say();
								StringCreator string44 = new StringCreator();
								string44.append("OK it's my turn now");
								state43.setText(string44.toString());
								if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 134, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching41 = true;
							if (rand42 >= 1 && rand42 < 2) {
								chosen40 = true;
								iristk.situated.SystemAgentFlow.say state45 = agent.new say();
								StringCreator string46 = new StringCreator();
								string46.append("Alright then. My turn");
								state45.setText(string46.toString());
								if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 134, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (true) {
							matching41 = true;
							if (rand42 >= 2 && rand42 < 3) {
								chosen40 = true;
								iristk.situated.SystemAgentFlow.say state47 = agent.new say();
								StringCreator string48 = new StringCreator();
								string48.append("Good job. Now me");
								state47.setText(string48.toString());
								if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 134, 12)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
					}
					iristk.situated.SystemAgentFlow.say state49 = agent.new say();
					StringCreator string50 = new StringCreator();
					string50.append("I pack my bag and I take with me");
					// Line: 134
					{
						RepeatHandler handler51 = new RepeatHandler();
						while (packingListIterator.hasNext()) {
							// Line: 134
							string50.append(packables.get(packingListIterator.next()));
							handler51.next();
						}
					}
					string50.append("and");
					state49.setText(string50.toString());
					if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 133, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 147
					PackRandomItem state52 = new PackRandomItem();
					if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 147, 34)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 148
					PlayerPacks state53 = new PlayerPacks();
					flowThread.gotoState(state53, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 148, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 133, 12));
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
			// Line: 156
			try {
				EXECUTION: {
					int count = getCount(971848845) + 1;
					incrCount(971848845);
					// Line: 157
					{
						RepeatHandler handler54 = new RepeatHandler();
						while (packingList.contains(randomPackable.getValue())) {
							// Line: 158
							randomPackable = packables.getRandom();
							handler54.next();
						}
					}
					// Line: 160
					packingList.add(randomPackable.getKey());
					iristk.situated.SystemAgentFlow.say state55 = agent.new say();
					StringCreator string56 = new StringCreator();
					// Line: 160
					string56.append(randomPackable.getValue());
					state55.setText(string56.toString());
					if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 156, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 164
					System.out.println("Packing list contains: " + packingList);
					// Line: 165
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 165, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 156, 12));
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
			// Line: 170
			try {
				EXECUTION: {
					int count = getCount(1869997857) + 1;
					incrCount(1869997857);
					// Line: 171
					packingList.clear();
					// Line: 172
					flowThread.returnFromCall(this, null, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 172, 13)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 170, 12));
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
			// Line: 178
			try {
				EXECUTION: {
					int count = getCount(1192108080) + 1;
					incrCount(1192108080);
					iristk.situated.SystemAgentFlow.say state57 = agent.new say();
					StringCreator string58 = new StringCreator();
					string58.append("Do you want to play again?");
					state57.setText(string58.toString());
					if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 178, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.listen state59 = agent.new listen();
					if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 178, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 178, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 182
			try {
				count = getCount(1068824137) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1068824137);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state60 = agent.new say();
							StringCreator string61 = new StringCreator();
							string61.append("Okay, let's play again.");
							state60.setText(string61.toString());
							if (!flowThread.callState(state60, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 182, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 184
							ClearPackingList state62 = new ClearPackingList();
							if (!flowThread.callState(state62, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 184, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 185
							PackIntro state63 = new PackIntro();
							flowThread.gotoState(state63, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 185, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 182, 58));
			}
			// Line: 187
			try {
				count = getCount(380894366) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(380894366);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state64 = agent.new say();
							StringCreator string65 = new StringCreator();
							string65.append("Okay, goodbye");
							state64.setText(string65.toString());
							if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 187, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 189
							ClearPackingList state66 = new ClearPackingList();
							if (!flowThread.callState(state66, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 189, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 190
							Idle state67 = new Idle();
							flowThread.gotoState(state67, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 190, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 187, 57));
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
			// Line: 195
			try {
				count = getCount(1608446010) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1608446010);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state68 = agent.new gesture();
							state68.setName("smile");
							if (!flowThread.callState(state68, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 195, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 195, 102));
			}
			// Line: 198
			try {
				count = getCount(992136656) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:stop")) {
						incrCount(992136656);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state69 = agent.new say();
							StringCreator string70 = new StringCreator();
							string70.append("Goodbye");
							state69.setText(string70.toString());
							if (!flowThread.callState(state69, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 198, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 202
							ClearPackingList state71 = new ClearPackingList();
							if (!flowThread.callState(state71, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 202, 36)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 203
							Idle state72 = new Idle();
							flowThread.gotoState(state72, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 203, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 198, 59));
			}
			// Line: 205
			try {
				count = getCount(1705929636) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1705929636);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state73 = agent.new say();
						StringCreator string74 = new StringCreator();
						string74.append("Sorry, I didn't get that.");
						state73.setText(string74.toString());
						if (!flowThread.callState(state73, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 205, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 207
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 207, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 205, 36));
			}
			// Line: 209
			try {
				count = getCount(1509514333) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1509514333);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state75 = agent.new attendOther();
						state75.setMode("eyes");
						if (!flowThread.callState(state75, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 209, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state76 = agent.new say();
						StringCreator string77 = new StringCreator();
						string77.append("I didn't ask you.");
						state76.setText(string77.toString());
						if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 209, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state78 = agent.new attendOther();
						state78.setMode("eyes");
						if (!flowThread.callState(state78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 209, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 213
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 213, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 209, 41));
			}
			// Line: 215
			try {
				count = getCount(1252585652) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1252585652);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state79 = agent.new say();
						StringCreator string80 = new StringCreator();
						string80.append("Don't speak at the same time.");
						state79.setText(string80.toString());
						if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 215, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 217
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 217, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 215, 42));
			}
			// Line: 219
			try {
				count = getCount(1785210046) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1785210046);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state81 = agent.new say();
						StringCreator string82 = new StringCreator();
						string82.append("Sorry, I didn't hear anything.");
						state81.setText(string82.toString());
						if (!flowThread.callState(state81, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 219, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 221
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 221, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 219, 38));
			}
			// Line: 223
			try {
				count = getCount(1361960727) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1361960727);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 224
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state83 = agent.new attendRandom();
								if (!flowThread.callState(state83, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 224, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 226
							} else {
								// Line: 227
								Idle state84 = new Idle();
								flowThread.gotoState(state84, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 227, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 223, 69));
			}
			// Line: 230
			try {
				count = getCount(166239592) + 1;
				if (event.triggers("repeat")) {
					incrCount(166239592);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 231
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 231, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\cynthia\\IrisTK\\app\\packingGame\\src\\iristk\\app\\packingGame\\PackingGameFlow.xml"), 230, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
