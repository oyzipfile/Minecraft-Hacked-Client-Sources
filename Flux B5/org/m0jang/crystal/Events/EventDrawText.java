package org.m0jang.crystal.Events;

import com.darkmagician6.eventapi.events.Event;

public class EventDrawText implements Event {
   public String text;

   public EventDrawText(String text) {
      this.text = text;
   }
}
