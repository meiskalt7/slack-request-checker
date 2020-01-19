# slack-request-checker
Verifying requests from Slack: https://api.slack.com/docs/verifying-requests-from-slack


# Usage
1) import org.meiskalt7.scala.slack.SlackRequestChecker
2) call SlackRequestChecker.verifySlackRequest(signature, signingSecret, timestamp, body)

*if encoding algorithm will have changed then you will can to call SlackRequestChecker.verifySlackRequest with additional parameter - algorithm: String
