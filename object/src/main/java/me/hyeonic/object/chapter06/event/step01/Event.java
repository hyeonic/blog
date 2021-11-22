package me.hyeonic.object.chapter06.event.step01;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    // 명령과 쿼리의 두 가지 역할을 동시에 수행한다.
    /*
     * isSatisfied 메서드는 Event가 RecurringSchedule의 조건에 부합하는지를 판단한 후 부합할 경우 true를, 부합하지 않을 경우 false를 반환한다.
    따라서 isSatisfied는 개념적으로 쿼리다.

     * isSatisfied 메서드는 Event가 RecurringSchedule의 조건에 부합하지 않는 경우 Event의 상태를 조건에 부합하도록 변경한다.
      따라서 isSatisfied는 실제로 부수효과를 가지는 명령이다.
     */
    public boolean isSatisfied(RecurringSchedule schedule) {
        if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
                !from.toLocalTime().equals(schedule.getFrom()) ||
                !duration.equals(schedule.getDuration())) {
            reschedule(schedule);
            return false;
        }

        return true;
    }

    // RecurringSchedule의 조건에 맞게 변경한다.
    private void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)), schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long daysDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}