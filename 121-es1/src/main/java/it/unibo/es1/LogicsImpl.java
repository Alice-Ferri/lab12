package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private final int size;
	private List<OneButton> listButtons = new ArrayList<>();

	private class OneButton{
		private int count;
		private boolean enable;

		public OneButton(final int count, final boolean enable){
			this.count = count;
			this.enable = enable;
		}

		public int getCount() {
			return count;
		}

		public boolean isEnable() {
			return enable;
		}

		public void setCount() {
			this.count++;
		}

		public void setNotEnable() {
			this.enable = false;
		}
	}

	public LogicsImpl(int size) {
		this.size = size;

		for(int i = 0; i < size; i++){
			listButtons.add(new OneButton(0, true));
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<Integer> values() {
		return listButtons.stream().map(v -> v.getCount()).toList();
	}

	@Override
	public List<Boolean> enablings() {
		return listButtons.stream().map(v -> v.isEnable()).toList();
	}

	@Override
	public int hit(int elem) {
		listButtons.get(elem).setCount();
		if (listButtons.get(elem).getCount() == this.size) {
			listButtons.get(elem).setNotEnable();
		}		
		return listButtons.get(elem).getCount();
	}

	@Override
	public String result() {
		return listButtons.stream().map(v -> String.valueOf(v.getCount())).collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return listButtons.stream().allMatch(v -> v.getCount() == listButtons.getFirst().getCount());
	}
}
