package com.Elibrary.demo;

import com.Elibrary.demo.Utils.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    public  void testThatUsernameCan_ContainTwoCharacters(){
       String name = " pe" ;
       assertFalse(Validator.validateName(name));
    }

    @Test
    public  void ValidateIfUsername_LengthCanExceed_LengthThirtyTwo(){
       String name = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertFalse(Validator.validateName(name));
    }

    @Test
    public  void ValidateIfUserName_LengthIsValid(){
        String name =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
        assertTrue(Validator.validateName(name));
    }

    @Test
    public  void ValidateThatUsername_CanContainUppercaseLetters(){
                assertTrue(Validator.validateName("PRECIOUS"));
    }

    @Test
    public  void ValidateThatUsername_CanContainLowercaseLetters(){
        assertTrue(Validator.validateName("precious"));

    }

    @Test
    public  void ValidateThatUsernameCanContainBothUppercaseAndLowercaseLetters(){
        assertTrue(Validator.validateName("preciouS"));

    }

    @Test
    public  void ValidateThatUppercaseLettersCanPrecedeLowercaseLetters(){
        assertTrue(Validator.validateName("Precious"));

    }

    @Test
    public  void ValidateThatLowercaseLettersCanPrecedeUppercaseLetters(){
        assertTrue(Validator.validateName("precioUs"));

    }

    @Test
    public  void ValidateThatUsername_CanContainSpaceCharacter(){
        assertFalse(Validator.validateName("precious joy"));

    }

    @Test
    public  void ValidateIfUsername_CanContainNumbers(){
        assertFalse(Validator.validateName("pressyGirl8"));

    }

    @Test
    public  void ValidateIfUsername_CanContainAtCharacter(){
        assertFalse(Validator.validateName("@pressyGirl"));

    }

    @Test
    public  void ValidateIfUsername_CanContainUnderscore(){
        assertTrue(Validator.validateName("pressy_Girl"));

    }
    @Test
    public  void ValidateIfUsername_CanContainHashtag(){
        assertFalse(Validator.validateName("#pressy"));

    }

    @Test
    public  void ValidateIfUsername_CanContainDollarSign(){
        assertFalse(Validator.validateName("pressy$"));

    }

    @Test
    public  void ValidateIfUsername_CanContainPercentageSymbol(){
        assertFalse(Validator.validateName("pressy%"));

    }

    @Test
    public  void ValidateIfUsername_CanContainCaretSymbol(){
        assertFalse(Validator.validateName("pressy^"));

    }

    @Test
    public  void ValidateIfUsernameCanContainAsteriskSymbol(){
        assertFalse(Validator.validateName("pressy*"));
    }

    @Test
    public  void ValidateIfUsername_CanContainAndSymbol(){
        assertFalse(Validator.validateName("pressy&"));

    }

    @Test
    public  void ValidateIfUsername_CanContainDashSymbol(){
        assertFalse(Validator.validateName("pres-sy"));

    }

    @Test
    public  void ValidateIfUsername_CanContainPlusSymbol(){
        assertFalse(Validator.validateName("pres+sy"));

    }

    @Test
    public  void ValidateIfUsername_CanContainEqualsSymbol(){

        assertFalse(Validator.validateName("pres== = ===sy"));

    }

    @Test
    public  void ValidateIfUsername_CanContainBackSlashSymbol(){
        assertFalse(Validator.validateName("\\pressy"));

    }
    @Test
    public  void ValidateIfUsername_CanContainForwardSlashSymbol(){
        assertFalse(Validator.validateName("pressy/"));

    }

    @Test
    public  void ValidateIfUsername_CanContainAnkleBracketsSymbol(){
        assertFalse(Validator.validateName("pre<>ssy"));

    }

    @Test
    public  void ValidateIfFirstAndLastnameCanContainFullstopsSymbol(){
        assertFalse(Validator.validateName("pressy."));

    }
    @Test
    public  void ValidateIfUsername_CanContainCommaSymbol(){
        assertFalse(Validator.validateName("press.y"));

    }

    @Test
    public  void ValidateIfUsername_CanContainBracketsSymbol(){
        assertFalse(Validator.validateName("pre()ssy"));

    }

    @Test
    public  void ValidateIfUsername_CanContainExclamationMark(){
        assertFalse(Validator.validateName("pressy!!!"));

    }

    @Test
    public  void ValidateIfUsername_CanContainSquareBracketsSymbol(){
        assertFalse(Validator.validateName("precio[]us"));

    }

    @Test
    public  void ValidateIfUsername_CanContainCurlyBraces(){
        assertFalse(Validator.validateName("pre{}ssy"));

    }

    @Test
    public  void ValidateIfUsername_CanContainSpecialSymbols(){
        assertFalse(Validator.validateName("pre~`!@#$%^&*()_+-= === == [{}]\\|;:''<>,./?ssy"));

    }



    @Test
    public void validateUserNameTest()  {
        assertTrue(Validator.validateName("Hadassah"));
    }

    @Test
    public void validateUserNameAgainTest()  {
        assertTrue(Validator.validateName("Hadassah"));
    }

    @Test
    public void validateUserPassword_LengthTest()  {
        assertTrue(Validator.validatePassword("fortunes"));
    }

    @Test
    public void CheckIfPasswordLength_ExceedsEightTest()  {
        assertTrue(Validator.validatePassword("ABCDEFGHI"));
    }
    @Test
    public void validatePassword__WithUppercaseLettersTest()  {
        assertTrue(Validator.validatePassword("PRECIOUS"));
    }

    @Test
    public void validatePassword__WithLowercaseLettersTest()  {
        assertTrue(Validator.validatePassword("precious"));
    }
    @Test
    public void validatePasswordWith_NumbersTest()  {
        assertTrue(Validator.validatePassword("Prec1234"));
    }

    @Test
    public void validatePassword__WithUnderScoreTest()  {
        assertFalse(Validator.validatePassword("_pressys"));
    }

    @Test
    public void validatePassword__WithTildeSymbolTest()  {
        assertFalse(Validator.validatePassword("~Pressy"));
    }

    @Test
    public void validatePassword__WithBacktickSymbolTest()  {

        assertFalse(Validator.validatePassword("`Pressy"));
    }

    @Test
    public void validatePassword__WithHashSymbolTest()  {
        assertFalse(Validator.validatePassword("#pressys"));
    }

    @Test
    public void validatePassword__WithCaretSymbolTest()  {
        assertFalse(Validator.validatePassword("pressys^"));
    }

    @Test
    public void validatePassword__WithAsteriskSymbolTest()  {
        assertFalse(Validator.validatePassword("pressys*"));
    }

    @Test
    public void validatePassword__WithCurlyBracesTest()  {
        assertFalse(Validator.validatePassword("{pressy}"));
    }

    @Test
    public void validatePassword__WithPercentageTest()  {
       assertFalse(Validator.validatePassword("%pressys"));
    }

    @Test
    public void validatePassword__WithAndTest()  {
        assertFalse(Validator.validatePassword("&pressys"));
    }

    @Test
    public void validatePassword__WithQuestionMarkTest()  {
        assertFalse(Validator.validatePassword("pressys?"));
    }

    @Test
    public  void testThatUserEmail_CanContainUppercase() {
        assertFalse(Validator.validateEmail("PRECIOUS"));
    }

    @Test
    public  void testThatUserEmail_CanContainLowercase() {
        assertFalse(Validator.validateEmail("precious"));
    }

    @Test
    public  void testThatUserEmail_CanContainAtSymbol() {
        assertFalse(Validator.validateEmail("@fortune"));
    }

    @Test
    public  void testThatUserEmail_CanContainFullstopsSymbol() {
        assertFalse(Validator.validateEmail("fortune."));
    }


    @Test
    public  void testThatUserEmail_CanContainTwoFullstopsSymbol() {
        assertFalse(Validator.validateEmail("fortune.."));
    }
    @Test
    public  void testThatUserEmail_CanContainNumbers() {
        assertFalse(Validator.validateEmail("fortune7277"));
    }

    @Test
    public  void testThatUserEmail_CanContainAllSpecialCharacters() {
        assertTrue(Validator.validateEmail("fortuneetim@gmail.com"));
    }
}
