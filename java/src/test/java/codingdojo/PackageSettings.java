package codingdojo;

import org.approvaltests.core.ApprovalFailureReporter;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.linux.MeldMergeReporter;

public class PackageSettings {
    public static ApprovalFailureReporter UseReporter         = MeldMergeReporter.INSTANCE;
}
