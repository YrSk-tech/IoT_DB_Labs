package com.syvak.view;


import com.syvak.controller.implementation.*;
import com.syvak.model.entity.*;


import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
    private final AwardController AwardController = new AwardController();
    private final DiscountsController discountsController = new DiscountsController();
    private final ReviewAgenciesController reviewAgenciesController = new ReviewAgenciesController();
    private final AgencyController agencyController = new AgencyController();
    private final ReviewAnimatorsController reviewAnimatorsController = new ReviewAnimatorsController();
    private final CustomController customController = new CustomController();
    private final AnimatorController animatorController = new AnimatorController();
    private final HolidayController holidayController = new HolidayController();

    private final Map<String, Printable> menu = new LinkedHashMap<>();


    public View() {
        menu.put("11", this::getAllAward);
        menu.put("12", this::getAwardById);
        menu.put("13", this::createAward);
        menu.put("14", this::updateAward);
        menu.put("15", this::deleteAward);

        menu.put("21", this::getAllDiscounts);
        menu.put("22", this::getDiscountsById);
        menu.put("23", this::createDiscounts);
        menu.put("24", this::updateDiscounts);
        menu.put("25", this::deleteDiscounts);

        menu.put("31", this::getAllReviewAgencies);
        menu.put("32", this::getReviewAgenciesById);
        menu.put("33", this::createReviewAgencies);
        menu.put("34", this::updateReviewAgencies);
        menu.put("35", this::deleteReviewAgencies);

        menu.put("41", this::getAllAgency);
        menu.put("42", this::getAgencyById);
        menu.put("43", this::createAgency);
        menu.put("44", this::updateAgency);
        menu.put("45", this::deleteAgency);

        menu.put("51", this::getAllReviewAnimators);
        menu.put("52", this::getReviewAnimatorsById);
        menu.put("53", this::createReviewAnimators);
        menu.put("54", this::updateReviewAnimators);
        menu.put("55", this::deleteReviewAnimators);

        menu.put("61", this::getAllCustom);
        menu.put("62", this::getCustomById);
        menu.put("63", this::createCustom);
        menu.put("64", this::updateCustom);
        menu.put("65", this::deleteCustom);

        menu.put("71", this::getAllAnimator);
        menu.put("72", this::getAnimatorById);
        menu.put("73", this::createAnimator);
        menu.put("74", this::updateAnimator);
        menu.put("75", this::deleteAnimator);

        menu.put("81", this::getAllHoliday);
        menu.put("82", this::getHolidayById);
        menu.put("83", this::createHoliday);
        menu.put("84", this::updateHoliday);
        menu.put("85", this::deleteHoliday);
    }

    public void displayMenu() {

        System.out.println("X - entity number:                 |       Y - CRUD number:");
        System.out.println("  1 - Award                       |         1 - GET ALL");
        System.out.println("  2 - Discounts                       |         2 - GET ONE");
        System.out.println("  3 - ReviewAgency                     |         3 - CREATE");
        System.out.println("  4 - Agency                     |         4 - UPDATE");
        System.out.println("  5 - ReviewAnimators                    |         5 - DELETE");
        System.out.println("  6 - Custom");
        System.out.println("  7 - Animator");
        System.out.println("  8 - Holiday");
        System.out.println("E.G. Awards (X=1) - get all (Y=1): 11");
        System.out.println("     ReviewAgency (X=3) - update (Y=4): 34");
        System.out.println("     Agency (X=4) - get one (Y=2): 42");
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose parameter:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    //Awards
    private void getAllAward() throws SQLException {
        System.out.println("\n[Award / GET]");
        System.out.println(AwardController.findAll() + "\n");
    }

    private void getAwardById() throws SQLException {
        System.out.println("\n[Award / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(AwardController.findOne(id) + "\n");
    }

    private Award getAwardInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();

        System.out.println("\nEnter year: ");
        Integer year = SCANNER.nextInt();

        System.out.println("\nEnter nomination: ");
        String nomination = SCANNER.next();

        System.out.println("\nEnter agencyId: ");
        Integer agencyId = SCANNER.nextInt();


        return new Award(name,year,nomination,agencyId);
    }

    private void createAward() throws SQLException {
        System.out.println("\n[Award / CREATE]");
        Award award = getAwardInputs();
        AwardController.create(award);
        System.out.println("Award created.\n");
    }

    private void updateAward() throws SQLException {
        System.out.println("\n[Award / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Award award = getAwardInputs();
        award.setId(id);

        AwardController.update(award.getId(), award);
        System.out.println("Award with ID=" + id + " successfully updated\n");
    }

    private void deleteAward() throws SQLException {
        System.out.println("\n[Award / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        AwardController.delete(id);
        System.out.println("Award with ID=" + id + " successfully deleted\n");
    }

    //  Discounts
    private void getAllDiscounts() throws SQLException {
        System.out.println("\n[DISCOUNTS / GET]");
        System.out.println(discountsController.findAll() + "\n");
    }

    private void getDiscountsById() throws SQLException {
        System.out.println("\n[DISCOUNTS / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(discountsController.findOne(id) + "\n");
    }

    private Discounts getDiscountsInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter cost: ");
        Float cost = SCANNER.nextFloat();
        System.out.println("\nEnter agency_id: ");
        Integer agency_id = SCANNER.nextInt();

        return new Discounts(name, cost, agency_id);
    }

    private void createDiscounts() throws SQLException {
        System.out.println("\n[DISCOUNTS / CREATE]");
        Discounts discounts = getDiscountsInputs();
        discountsController.create(discounts);
        System.out.println("DISCOUNTS created.\n");
    }

    private void updateDiscounts() throws SQLException {
        System.out.println("\n[DISCOUNTS / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Discounts discounts = getDiscountsInputs();
        discounts.setId(id);

        discountsController.update(discounts.getId(), discounts);
        System.out.println("DISCOUNTS with ID=" + id + " successfully updated\n");
    }

    private void deleteDiscounts() throws SQLException {
        System.out.println("\n[DISCOUNTS / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        discountsController.delete(id);
        System.out.println("DISCOUNTS with ID=" + id + " successfully deleted\n");
    }

    //  reviewAgencys
    private void getAllReviewAgencies() throws SQLException {
        System.out.println("\n[REVIEW AGENCIES / GET]");
        System.out.println(reviewAgenciesController.findAll() + "\n");
    }

    private void getReviewAgenciesById() throws SQLException {
        System.out.println("\n[REVIEW AGENCIES / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(reviewAgenciesController.findOne(id) + "\n");
    }

    private ReviewAgency getReviewAgenciesInputs() {
        System.out.println("\nEnter author: ");
        String author = SCANNER.next();
        System.out.println("\nEnter text: ");
        String text = SCANNER.next();

        return new ReviewAgency(author, text );
    }

    private void createReviewAgencies() throws SQLException {
        System.out.println("\n[REVIEW AGENCIES / CREATE]");
        ReviewAgency reviewAgencies = getReviewAgenciesInputs();
        reviewAgenciesController.create(reviewAgencies);
        System.out.println("REVIEW AGENCIES created.\n");
    }

    private void updateReviewAgencies() throws SQLException {
        System.out.println("\n[REVIEW AGENCIES / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        ReviewAgency reviewAgencies = getReviewAgenciesInputs();
        reviewAgencies.setId(id);

        reviewAgenciesController.update(reviewAgencies.getId(), reviewAgencies);
        System.out.println("REVIEW AGENCIES with ID=" + id + " successfully updated\n");
    }

    private void deleteReviewAgencies() throws SQLException {
        System.out.println("\n[REVIEW AGENCIES / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        reviewAgenciesController.delete(id);
        System.out.println("REVIEW AGENCIES with ID=" + id + " successfully deleted\n");
    }

    //  agency
    private void getAllAgency() throws SQLException {
        System.out.println("\n[AGENCY / GET]");
        System.out.println(agencyController.findAll() + "\n");
    }

    private void getAgencyById() throws SQLException {
        System.out.println("\n[AGENCY / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(agencyController.findOne(id) + "\n");
    }

    private Agency getAgencyInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter phone_number: ");
        Integer phone_number = SCANNER.nextInt();

        return new Agency(name,phone_number);
    }

    private void createAgency() throws SQLException {
        System.out.println("\n[AGENCY / CREATE]");
        Agency agency = getAgencyInputs();
        agencyController.create(agency);
        System.out.println("AGENCY created.\n");
    }

    private void updateAgency() throws SQLException {
        System.out.println("\n[AGENCY / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Agency agency = getAgencyInputs();
        agency.setId(id);

        agencyController.update(agency.getId(), agency);
        System.out.println("AGENCY with ID=" + id + " successfully updated\n");
    }

    private void deleteAgency() throws SQLException {
        System.out.println("\n[AGENCY / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        agencyController.delete(id);
        System.out.println("AGENCY with ID=" + id + " successfully deleted\n");
    }

    //  ReviewAnimators
    private void getAllReviewAnimators() throws SQLException {
        System.out.println("\n[REVIEW ANIMATOR / GET]");
        System.out.println(reviewAnimatorsController.findAll() + "\n");
    }

    private void getReviewAnimatorsById() throws SQLException {
        System.out.println("\n[REVIEW ANIMATOR / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(reviewAnimatorsController.findOne(id) + "\n");
    }

    private ReviewAnimators getReviewAnimatorsInputs() {
        System.out.println("\nEnter author: ");
        String author = SCANNER.next();
        System.out.println("\nEnter text: ");
        String text = SCANNER.next();
        System.out.println("\nEnter animator_id: ");
        Integer animator_id = SCANNER.nextInt();

        return new ReviewAnimators(author, text, animator_id);
    }

    private void createReviewAnimators() throws SQLException {
        System.out.println("\n[REVIEW ANIMATOR / CREATE]");
        ReviewAnimators reviewAnimators = getReviewAnimatorsInputs();
        reviewAnimatorsController.create(reviewAnimators);
        System.out.println("REVIEW ANIMATOR created.\n");
    }

    private void updateReviewAnimators() throws SQLException {
        System.out.println("\n[REVIEW ANIMATOR / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        ReviewAnimators reviewAnimators = getReviewAnimatorsInputs();
        reviewAnimators.setId(id);

        reviewAnimatorsController.update(reviewAnimators.getId(), reviewAnimators);
        System.out.println("REVIEW ANIMATOR with ID=" + id + " successfully updated\n");
    }

    private void deleteReviewAnimators() throws SQLException {
        System.out.println("\n[REVIEW ANIMATOR / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        reviewAnimatorsController.delete(id);
        System.out.println("REVIEW ANIMATOR with ID=" + id + " successfully deleted\n");
    }

    //  custom
    private void getAllCustom() throws SQLException {
        System.out.println("\n[CUSTOM / GET]");
        System.out.println(customController.findAll() + "\n");
    }

    private void getCustomById() throws SQLException {
        System.out.println("\n[CUSTOM / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(customController.findOne(id) + "\n");
    }

    private Custom getCustomInputs() {
        System.out.println("\nEnter date: ");
        String date = SCANNER.next();
        System.out.println("\nEnter duration_in_hours: ");
        Integer duration_in_hours = SCANNER.nextInt();
        System.out.println("\nEnter address: ");
        String address = SCANNER.next();
        System.out.println("\nEnter cost_in_uah: ");
        Integer cost_in_uah = SCANNER.nextInt();

        return new Custom(date, duration_in_hours, address, cost_in_uah);
    }

    private void createCustom() throws SQLException {
        System.out.println("\n[CUSTOM / CREATE]");
        Custom custom = getCustomInputs();
        customController.create(custom);
        System.out.println("CUSTOM created.\n");
    }

    private void updateCustom() throws SQLException {
        System.out.println("\n[CUSTOM / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Custom custom = getCustomInputs();
        custom.setId(id);

        customController.update(custom.getId(), custom);
        System.out.println("CUSTOM with ID=" + id + " successfully updated\n");
    }

    private void deleteCustom() throws SQLException {
        System.out.println("\n[CUSTOM / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        customController.delete(id);
        System.out.println("CUSTOM with ID=" + id + " successfully deleted\n");
    }

    //  Animator
    private void getAllAnimator() throws SQLException {
        System.out.println("\n[ANIMATOR / GET]");
        System.out.println(animatorController.findAll() + "\n");
    }

    private void getAnimatorById() throws SQLException {
        System.out.println("\n[ANIMATOR / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(animatorController.findOne(id) + "\n");
    }

    private Animator getAnimatorInputs() {
        System.out.println("\nEnter user id: ");
        Integer id = SCANNER.nextInt();
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter surname: ");
        String surname = SCANNER.next();
        System.out.println("\nEnter last_name: ");
        String last_name = SCANNER.next();
        System.out.println("\nEnter age: ");
        Integer age = SCANNER.nextInt();


        return new Animator(id, name, surname, last_name, age);
    }

    private void createAnimator() throws SQLException {
        System.out.println("\n[ANIMATOR / CREATE]");
        Animator animator = getAnimatorInputs();
        animatorController.create(animator);
        System.out.println("ANIMATOR created.\n");
    }

    private void updateAnimator() throws SQLException {
        System.out.println("\n[ANIMATOR / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Animator animator = getAnimatorInputs();
        animator.setId(id);

        animatorController.update(animator.getId(), animator);
        System.out.println("ANIMATOR with ID=" + id + " successfully updated\n");
    }

    private void deleteAnimator() throws SQLException {
        System.out.println("\n[ANIMATOR / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        animatorController.delete(id);
        System.out.println("ANIMATOR with ID=" + id + " successfully deleted\n");
    }

    //    Holiday
    private void getAllHoliday() throws SQLException {
        System.out.println("\n[HOLIDAY / GET]");
        System.out.println(holidayController.findAll() + "\n");
    }

    private void getHolidayById() throws SQLException {
        System.out.println("\n[HOLIDAY / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(holidayController.findOne(id) + "\n");
    }

    private Holiday getHolidayInputs() {
        System.out.println("\nEnter type: ");
        String type = SCANNER.next();
        System.out.println("\nEnter number_of_animators id: ");
        Integer number_of_animators = SCANNER.nextInt();
        System.out.println("\nEnter number_of_participants: ");
        Integer number_of_participants = SCANNER.nextInt();
        System.out.println("\nEnter custom_id: ");
        Integer custom_id = SCANNER.nextInt();

        return new Holiday(type, number_of_animators, number_of_participants, custom_id);
    }

    private void createHoliday() throws SQLException {
        System.out.println("\n[HOLIDAY / CREATE]");
        Holiday holiday = getHolidayInputs();
        holidayController.create(holiday);
        System.out.println("HOLIDAY created.\n");
    }

    private void updateHoliday() throws SQLException {
        System.out.println("\n[HOLIDAY / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Holiday holiday = getHolidayInputs();
        holiday.setId(id);

        holidayController.update(holiday.getId(), holiday);
        System.out.println("HOLIDAY with ID=" + id + " successfully updated\n");
    }

    private void deleteHoliday() throws SQLException {
        System.out.println("\n[HOLIDAY / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        holidayController.delete(id);
        System.out.println("HOLIDAY with ID=" + id + " successfully deleted\n");
    }
}